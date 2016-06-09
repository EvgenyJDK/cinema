package com.cinema.dao.api;

import com.cinema.model.User;
import com.cinema.service.api.UserService;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List <User> findAllUsers();

    void saveUser(User user); // throws SQLException, PropertyVetoException;

    User findUserByLoginPassword (String login, String password);

    void deleteUserById (int userID);


//    UserService getInstance();
}
