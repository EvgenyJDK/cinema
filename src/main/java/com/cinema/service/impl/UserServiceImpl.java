package com.cinema.service.impl;

import com.cinema.Transformer;
import com.cinema.dao.api.UserDAO;
import com.cinema.dao.impl.UserDAOImpl;
import com.cinema.dao.impl.UserDAOMySQLImpl;
import com.cinema.dao.storage.PropertyHolder;
import com.cinema.dto.UserDTO;
import com.cinema.model.User;
import com.cinema.service.api.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    // Блок инициализации InMemoryDB или MySQL                                      // KST

    private static UserServiceImpl userService;                         // LN
    //    public  static UserServiceImpl userService;

    //  синглтон ???
    public static UserServiceImpl getInstance() {
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                if (userService == null) {
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }


//    public static UserServiceImpl getInstance () {                                   // mdf dstp Q
//        PropertyHolder.getInstance();                                               //  Q
////        if (PropertyHolder.isInMemoryDB()){
//        if (true){
//            userService = UserDAOImpl.getInstance();
//        } else {
//            userService = UserDAOMySQLImpl.getInstance();
//        }
//        return userService;
//    }




    //    public  static UserDAO userDAO;

//    public static UserDAO getInstance () {                                            // mdf dstp Q
//        PropertyHolder.getInstance();                                               // Q
////        if (PropertyHolder.isInMemoryDB()){
//        if (true){
//            userDAO = UserDAOImpl.getInstance();
//        } else {
//            userDAO = UserDAOMySQLImpl.getInstance();
//        }
//        return userDAO;
//    }


//    static {                                                                        // mdf dstp Q
//        PropertyHolder.getInstance();                                               // Q
//        if (PropertyHolder.isInMemoryDB()){
//            userDAO = UserDAOImpl.getInstance();
//        } else {
//            userDAO = UserDAOMySQLImpl.getInstance();
//        }
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



    @Override
    public List <UserDTO> getAllUsers() {
//        UserDAO userDAO = UserDAOImpl.getInstance();                    // LN
        UserDAO userDAO = new UserDAOImpl();                          // хардкод вкл. базы инмемори
//        UserDAO userDAO = new UserDAOMySQLImpl();                       // хардкод вкл. базы MySQL
        List<User> allUsers = userDAO.findAllUsers();
        List<UserDTO> userDTOs = Transformer.ListUserToListUserDTO(allUsers);
        return userDTOs;
    }

    @Override
    public void createUser(UserDTO userDto) {

//        UserDAO userDAO = UserDAOImpl.getInstance();                    // LN
//        UserDAO userDAO = new UserDAOImpl();                          // хардкод вкл. базы инмемори
        UserDAO userDAO = new UserDAOMySQLImpl();
        User user = Transformer.userDtoToUser(userDto);
        userDAO.saveUser(user);
    }

    @Override
    public UserDTO findUserByLoginPassword(String login, String password)  {       //throws IncorrectLoginOrPasswordException
//        UserDAO userDAO;
//        if(!PropertyHolder.getInstance().isInMemoryDB()) {
//            userDAO = UserDAOMySQLImpl.getInstance();
//        }else {
//            userDAO = UserDAOImpl.getInstance();
//        }

//        UserDAO userDAO = new UserDAOImpl();                                      // хардкод вкл. базы инмемори
        UserDAO userDAO = new UserDAOMySQLImpl();                                 // хардкод вкл. базы MySQL
        User user = userDAO.findUserByLoginPassword(login, password);
        UserDTO userDTO = null;
        if(user != null) {
            userDTO = Transformer.userToUserDTO(user);
        }
        return userDTO;



//        UserDAO userDAO;
//        if(!PropertyReader.getInstance().isInMemoryDB()) {
//            userDAO = UserDAOInMemoryImpl.getInstance();
//        }else {
//            userDAO = UserDAOImpl.getInstance();
//        }
//        User user = userDAO.findUserByLoginPassword(login, password);
//        UserDTO userDTO = null;
//        if(user != null) {
//            userDTO = UserTransformer.userToUserDTO(user);
//        }
//        return userDTO;
//


    }

    @Override
    public void deleteUserById(int userID) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.deleteUserById(userID);

    }

}



//    private static UserServiceImpl userService;                         // LN
//
//    public static UserServiceImpl getInstance() {
//        System.out.println("Class " + UserServiceImpl.class);
//        if (userService == null) {
//            System.out.println("Class " + UserServiceImpl.class);
//            synchronized (UserServiceImpl.class) {
//                if (userService == null) {
//                    userService = new UserServiceImpl();
//                }
//            }
//        }
//        return userService;
//    }