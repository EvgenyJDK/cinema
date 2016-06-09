package com.cinema.service.api;


import com.cinema.dto.UserDTO;
import com.cinema.model.User;

import java.util.List;

public interface UserService {

    List <UserDTO> getAllUsers ();

    void createUser (UserDTO user);

    UserDTO findUserByLoginPassword (String login, String password);

    void deleteUserById (int userID);


}
