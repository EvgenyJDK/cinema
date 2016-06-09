package com.cinema.dao.impl;

import com.cinema.dao.api.UserDAO;
import com.cinema.datasource.DataSource;
import com.cinema.model.Role;
import com.cinema.model.User;
import com.cinema.service.impl.UserServiceImpl;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.List;

/**
 * Created by User on 13.04.2016.
 */
public class UserDAOMySQLImpl implements UserDAO {

    private static UserDAOMySQLImpl userDAOMySQL;

    public static UserDAOMySQLImpl getInstance() {
        System.out.println("!!!!!!!!!!");
        System.out.println("Hello UserDAOMySQLImpl");

           if (userDAOMySQL == null){
            synchronized (UserDAOImpl.class) {
                if (userDAOMySQL == null){
                    userDAOMySQL = new UserDAOMySQLImpl();
                }
            }
        }
        return userDAOMySQL;
    }


//    public static UserDAOImpl getInstance(){
//        if (userDAOInMemory == null){
//            synchronized (UserDAOImpl.class) {
//                if (userDAOInMemory == null){
//                    userDAOInMemory = new UserDAOImpl();
//                }
//            }
//        }
//        return userDAOInMemory;
//    }


//    public static UserServiceImpl getInstance(){
//        if(userService == null){
//            synchronized (UserServiceImpl.class){
//                if(userService == null){
//                    userService = new UserServiceImpl();
//                }
//            }
//        }
//        return userService;
//    }

//    public static final String INSERT = "INSERT INTO %s %s";
//    public static final String QUERY = "INSERT INTO user (name, age) VALUES (?,?)";
    public static final String INSERT_USER = "INSERT INTO user (firstName, lastName, email, login, password, role) values (?,?,?,?,?,?)";
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM cinema.user WHERE login =? AND password =?";


    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public void saveUser(User user) {

        System.out.println("UserDAOMySQLImpl saveuser");

        Connection connection = null;
        try {
            System.out.println("\"UserDAOMySQLImpl trying to get connection");
            connection = DataSource.getInstance().getConnection();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        System.out.println("UserDAOMySQLImpl try to insert");

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getRole().name());

            preparedStatement.executeUpdate();
            ResultSet userResultSet = preparedStatement.getGeneratedKeys();
            userResultSet.next();
            user.setId(userResultSet.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByLoginPassword(String login, String password) {

        Connection connection = null;
        User result = null;

        try {
            connection = DataSource.getInstance().getConnection();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = createSelectStatement(connection, login, password);
            ResultSet userResultSet = preparedStatement.executeQuery();
            userResultSet.next();

            result = mapUser(userResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    private PreparedStatement createSelectStatement(Connection connection, String login, String password) throws SQLException {

        PreparedStatement preparedStatement;
        String userSQL = String.format(FIND_USER_BY_LOGIN_AND_PASSWORD);
        preparedStatement = connection.prepareStatement(userSQL);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        return preparedStatement;
    }

    protected User mapUser(ResultSet userResultSet) throws SQLException {
        User user = null;
        if(userResultSet.getRow() > 0) {
            user = new User();
            user.setId(userResultSet.getInt("id"));
            user.setFirstName(userResultSet.getString("firstName"));
            user.setLastName(userResultSet.getString("lastName"));
            user.setLogin(userResultSet.getString("login"));
            user.setPassword(userResultSet.getString("password"));
            user.setRole(Role.valueOf(userResultSet.getString("role")));
            user.setEmail(userResultSet.getString("email"));
        }
        return user;
    }



    @Override
    public void deleteUserById(int userID) {

    }

}
