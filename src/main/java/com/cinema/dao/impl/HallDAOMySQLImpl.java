package com.cinema.dao.impl;

import com.cinema.dao.api.HallDAO;
import com.cinema.datasource.DataSource;
import com.cinema.model.Hall;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Админ on 20.04.2016.
 */
public class HallDAOMySQLImpl implements HallDAO {

    public static final String FIND_HALL_BY_NAME = "SELECT * FROM cinema.hall WHERE name =?";
    public static final String INSERT_HALL = "INSERT INTO hall (name, rowCount, columnCount) values (?,?,?)";
    public static final String SELECT_ALL = "SELECT * FROM %s";
    public static final String DELETE = "DELETE FROM %s WHERE id =?";


    private static HallDAO hallDAO = null;

    public static HallDAO getInstance() {
        System.out.println("!!!!!!!!!!");
        System.out.println("Hello HallDAOMySQLImpl");

//        if (userDAO==null){
//            synchronized (UserDAOMySQLImpl.class){
//                if (userDAO==null){
//                    userDAO = new UserDAOMySQLImpl();
//                }
//            }
//        }

        return hallDAO;
    }


    @Override
    public List<Hall> findAllHalls() {

        System.out.println("HallDAOMySQLImpl findAllHalls");
        String sql = String.format(SELECT_ALL, "cinema.hall");
        Connection connection = null;
        List hallResult = null;
        try {
            try {
                connection = DataSource.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                hallResult = readAll(resultSet);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hallResult;
    }

    private List<Hall> readAll(ResultSet resultSet) throws SQLException {
        System.out.println("HallDAOMySQLImpl readAll from findAllHalls");

        List<Hall> result = new LinkedList<>();

        while (resultSet.next()) {

            Hall hall = mapHall(resultSet);
            result.add(hall);
        }
        return result;
    }


    @Override
    public Hall findHallByName(String hallName) {

        Connection connection = null;
        Hall result = null;
        try {
            System.out.println("HallDAOMySQL Impl trying to get connection");
            connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = createSelectStatement(connection, hallName);
            ResultSet hallResultSet = preparedStatement.executeQuery();
            hallResultSet.next();
            result = mapHall(hallResultSet);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private PreparedStatement createSelectStatement(Connection connection, String hallName) throws SQLException {
        PreparedStatement preparedStatement;

        String userSQL = String.format(FIND_HALL_BY_NAME);
        preparedStatement = connection.prepareStatement(userSQL);
        preparedStatement.setString(1, hallName);

        return preparedStatement;
    }

    protected Hall mapHall(ResultSet resultSet) throws SQLException {
        Hall hall = null;
        if (resultSet.getRow() > 0) {
            System.out.println("HallDAOMySQLImpl mapHall");
            hall = new Hall();
            hall.setId(resultSet.getInt("id"));
            hall.setName(resultSet.getString("name"));
            hall.setQuantityOfRows(resultSet.getInt("rowCount"));
            hall.setPlacesInRow(resultSet.getInt("columnCount"));
        }
        return hall;
    }


    @Override
    public void saveHall(Hall hall) {

        System.out.println("HallDAOMySQLImpl saveHall");
        Connection connection = null;

        try {
            connection = DataSource.getInstance().getConnection();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        System.out.println("HallDAOMySQLImpl try to insert");


        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(INSERT_HALL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, hall.getName());
            preparedStatement.setString(2, String.valueOf(hall.getQuantityOfRows()));
            preparedStatement.setLong(3, hall.getPlacesInRow());
            preparedStatement.executeUpdate();

            ResultSet hallResultSet = preparedStatement.getGeneratedKeys();
            hallResultSet.next();
            hall.setId(hallResultSet.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteHallByName(String hallName) {

    }

    @Override
    public Hall deleteHall(Hall hall) {
        return null;
    }


    @Override
    public void deleteMovie(int hall_id) {

        Connection connection = null;
        try {
            System.out.println("HallDAOMySQLImpl deleteMovie");
            connection = DataSource.getInstance().getConnection();
            createDeleteStatement(connection, hall_id);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createDeleteStatement(Connection connection, int hall_id) throws SQLException {
        PreparedStatement preparedStatement;


        preparedStatement = connection.prepareStatement("DELETE FROM ticket where session_id=" + "ANY (SELECT session.id FROM session WHERE hall_id=?);");
        preparedStatement.setInt(1, hall_id);
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("DELETE FROM session where hall_id=?");
        preparedStatement.setInt(1, hall_id);
        preparedStatement.executeUpdate();

        String hallSQL = String.format(DELETE, "cinema.hall");     // + stringMap.get(entityClass));
        preparedStatement = connection.prepareStatement(hallSQL);
        preparedStatement.setInt(1, hall_id);
        preparedStatement.executeUpdate();
    }
}
