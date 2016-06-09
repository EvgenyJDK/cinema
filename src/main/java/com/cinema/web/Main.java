package com.cinema.web;

import com.cinema.dao.storage.PropertyHolder;
import com.cinema.datasource.DataSource;
import com.cinema.dto.*;
import com.cinema.model.Role;
import com.cinema.service.api.*;
import com.cinema.service.impl.*;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

    public static final String INSERT_USER = "INSERT products (id, description, details, price) VALUES (9, 'Новый товар2', 'Описание товара2', 35.45);\n";

    public static void main (String [] args) throws PropertyVetoException, SQLException {

//        DataSource connectionMYSQL = new DataSource();
//        connectionMYSQL.getConnection();


        MovieService movieService = new MovieServiceImpl();
        MovieDTO movieDTO1 = new MovieDTO(1, "KINO", "FILM", 5000l);
        MovieDTO movieDTO2 = new MovieDTO();
        movieDTO2.setDescription("testDescription");
        movieDTO2.setDuration((long) 1000);
        movieDTO2.setTitle("testTitle");
        movieService.createMovie(movieDTO1);                                                        // create movie
        movieService.createMovie(movieDTO2);
        List <MovieDTO> allMovies = movieService.getAllMovies();
        System.out.println(allMovies);
        System.out.println("~~~~~~~");
        movieService.updateMovie(movieDTO2);                                                        // update movie
        System.out.println("~~~~~~~");
//        System.out.println(allMovies);
        movieService.deleteMovie(movieDTO1);                                                        //  delete movie Q
        System.out.println(allMovies);


        UserService userService = new UserServiceImpl();

//        Как юзеру добавить Purchased Ticket  ??????????????????????????
//        UserDTO userDTO1 = new UserDTO(1, "Evgeny", "Surname", "evgeny", "evgeny", 2000,9,1, "evgeny@mail.ru", Purchased ticket, Role.ADMIN);
//        userDTO1.setPurchasedTicket();

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(5);                                                // set ID Q
        userDTO2.setFirstName("Ivan");
        userDTO2.setLastName("Ivanov");
        userDTO2.setLogin("user");
        userDTO2.setPassword("user");
        userDTO2.setBirthday(2000, 1, 1);
        userDTO2.setEmail("ivan@mail.ru");
        userDTO2.setRole(Role.USER);
//        userService.createUser(userDTO1);                               // create user userDTO1 не создается без Purchased Ticket
        userService.createUser(userDTO2);                                 // create user userDTO2 создается без Purchased Ticket
        List <UserDTO> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
        System.out.println("~~~~~~~");
        System.out.println("Found " + userService.findUserByLoginPassword("user", "user"));         // поиск userDTO2 по логину/паролю
        userService.deleteUserById(1);                                                              // remove via ID Q
        System.out.println(allUsers);


        HallService hallService = new HallServiceImpl();
        HallDTO hallDTO1 = new HallDTO(1,"RED hall", 10, 15);
        HallDTO hallDTO2 = new HallDTO(2,"GREEN hall", 20, 30);
        hallService.createHall(hallDTO1);                                                // create hall
        hallService.createHall(hallDTO2);
        List<HallDTO> allHalls = hallService.findAllHalls();
        System.out.println(allHalls);
        System.out.println("~~~~~~~");
        hallService.deleteHall(hallDTO1);                                                 // delete hall (like object)Q
//        hallService.deleteHallByName("RED hall");                                       // remove hall via name Q
        System.out.println(allHalls);


        TicketService ticketService = new TicketServiceImpl();
//        TicketDTO ticketDTO = new TicketDTO(1, 1, 1, true);                           // // TODO: 05.05.2016  to check constructor 
//        TicketDTO ticketDTO = new TicketDTO(1, 1, 1, 1, true);
//        ticketService.purchaseTicket(ticketDTO);
        List<TicketDTO> allTickets = ticketService.findAllTickets();
        System.out.println(allTickets);


        SessionService sessionService = new SessionServiceImpl();
        SessionDTO sessionDTO = new SessionDTO(1, 2000,04, 12, movieDTO1, hallDTO1);   //, allTickets);    // set allTickets + hallDTO Q
        sessionService.createSession(sessionDTO);
//        sessionService.createListOfTickets(hallDTO.getId());                                      // не обязательно
        List<SessionDTO> allSessions = sessionService.getAllSessions();
        System.out.println(allSessions);



        DataSource dt = new DataSource();
        dt.getConnection();

        }
    }

