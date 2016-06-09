package com.cinema.web;

import com.cinema.dto.HallDTO;
import com.cinema.service.api.HallService;
import com.cinema.service.impl.HallServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Админ on 08.05.2016.
 */
public class AddHallServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (true) {
                resp.sendRedirect("/addHall.html");
            } else {
                resp.sendRedirect("/films");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String hallName = request.getParameter("title");
            short rows = Short.valueOf(request.getParameter("rows"));
            short columns = Short.valueOf(request.getParameter("columns"));
            HallService hallService = HallServiceImpl.getInstance();
            HallDTO hallDTO = hallService.findHallByName(hallName);
            if (hallDTO == null) {
                hallDTO = new HallDTO();
                hallDTO.setName(hallName);
                hallDTO.setQuantityOfRows(rows);
                hallDTO.setPlacesInRow(columns);

                System.out.println("AddHallServlet - before creating hall");

                hallService.createHall(hallDTO);
                request.setAttribute("entity", "hall");
                request.setAttribute("hall", hallDTO);
                getServletContext().getRequestDispatcher("/resources/jsp/info.jsp").include(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/addHall.html");
                PrintWriter out = response.getWriter();
                out.println("<font color=red><strong>Hall name is already exists.</strong></font>");
                rd.include(request, response);
            }
        }
    }



