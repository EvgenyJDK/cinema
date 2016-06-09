package com.cinema.web;


import com.cinema.dto.UserDTO;
import com.cinema.model.Role;
import com.cinema.service.api.UserService;
import com.cinema.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/resources/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Registration Servlet");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserService userService = UserServiceImpl.getInstance();
        UserDTO userDTO = userService.findUserByLoginPassword(login, password);

        if (userDTO == null) {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");

            /*валидация всех полей*/

            userDTO = new UserDTO();
            userDTO.setFirstName(firstName);
            userDTO.setLastName(lastName);
            userDTO.setEmail(email);
            userDTO.setRole(Role.USER);
            userDTO.setLogin(login);
            userDTO.setPassword(password);
            userService.createUser(userDTO);                                     /*сохраняем нашего пользователя*/


            // ПОСЛЕ УСПЕШНОЙ РЕГИСТРАЦИИ ОТКРЫВАЕМ СЕССИЮ И ВЫВОДИМ ПРИВЕТСТВИЕ ОБ УСПЕШНОМ ЛОГИРОВАНИИ

            HttpSession session = req.getSession();
            session.setAttribute("user", userDTO);
            req.setAttribute("firstName", firstName);
            req.setAttribute("lastName", lastName);
            req.getRequestDispatcher("/resources/jsp/loginSuccess.jsp").forward(req, resp);

        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/registration.jsp");
            PrintWriter out= resp.getWriter();
            out.println("<font color=red>User with such login already exists! Please choose another login </font>");
            rd.include(req, resp);
        }
    }




////          ПРЯМОЕ ДОБАВЛЕНИЕ USER И ВЫВОД ПРИВЕТСТВИЯ ОБ УСПЕШНОМ ЛОГИРОВАНИИ
//
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String email = req.getParameter("email");
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//
//        UserService userService = UserServiceImpl.getInstance();
//        User user = new User(firstName, lastName, email, login, password);
//
//        UserDTO userDTO = new UserDTO();
////        userDTO.setId(5);                                                // set ID Q
//        userDTO.setFirstName(firstName);
//        userDTO.setLastName(lastName);
//        userDTO.setLogin(login);
//        userDTO.setPassword(password);
////        userDTO.setBirthday(2000, 1, 1);
//        userDTO.setEmail(email);
//        userDTO.setRole(Role.USER);
//        userService.createUser(userDTO);
//
//        HttpSession session = req.getSession();
//        session.setAttribute("user", user);
//        req.setAttribute("firstName", firstName);
//        req.setAttribute("lastName", lastName);
//        req.getRequestDispatcher("/resources/jsp/loginSuccess.jsp").forward(req, resp);
//
//        // для отображения в jsp странице подключаем библиотеку
//        // <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
//        // и jstl dependency в pom.xml
//
//        PrintWriter out= resp.getWriter();
//        out.println(user.getFirstName());
//    }

}

