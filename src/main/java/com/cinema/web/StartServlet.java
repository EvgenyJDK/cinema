package com.cinema.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Админ on 27.04.2016.
 */
public class StartServlet extends HttpServlet {

    // mvc (model)

    // call service

    // call dao


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/login.jsp");
        rd.forward(request, response);

    }
}
