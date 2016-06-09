package com.cinema.dao.impl;

import com.cinema.dao.api.UserDAO;
import com.cinema.dao.storage.InMemoryDB;
import com.cinema.dao.storage.PropertyHolder;
import com.cinema.model.User;
import com.cinema.service.impl.UserServiceImpl;

import java.util.List;

public class UserDAOImpl implements UserDAO {


    private static UserDAOImpl userDAOInMemory;

    public static UserDAOImpl getInstance(){
        if (userDAOInMemory == null){
            synchronized (UserDAOImpl.class) {
                if (userDAOInMemory == null){
                    userDAOInMemory = new UserDAOImpl();
                }
            }
        }
        return userDAOInMemory;
    }


    @Override
    public List<User> findAllUsers() {
        InMemoryDB instance = InMemoryDB.getInstance();
        List<User> users = instance.fetchAllUsers();
        return users;
    }

    @Override
    public void saveUser(User user) {
//        if (PropertyHolder.getInstance().isInMemoryDB()) {
//        } else {
            InMemoryDB instance = InMemoryDB.getInstance();
            instance.saveUser(user);
//        }
    }

    @Override
    public User findUserByLoginPassword(String login, String password) {
        InMemoryDB instance = InMemoryDB.getInstance();
        User user = instance.findUserByLoginPassword(login, password);
        return user;
    }

    @Override
    public void deleteUserById(int userID) {
        InMemoryDB instance = InMemoryDB.getInstance();
        instance.deleteUserByID(userID);
    }

}




