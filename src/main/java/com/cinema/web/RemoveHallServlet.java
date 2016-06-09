package com.cinema.web;

import com.cinema.service.api.HallService;
import com.cinema.service.impl.HallServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Админ on 08.05.2016.
 */
public class RemoveHallServlet extends HttpServlet {

    public static final String HALL_ID = "hallID";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HallService hallService = HallServiceImpl.getInstance();

        if (true) {
                if (request.getParameter(HALL_ID) != null) {
                    int hall_id = Integer.parseInt(request.getParameter(HALL_ID));
                    hallService.deleteHall(hall_id);
                    response.sendRedirect("/administration");
                } else {
                    request.getSession().setAttribute("exception", "Please, select hall");
                    response.sendRedirect(request.getHeader("Referer"));
                }
            } else {
                response.sendRedirect("/films");
            }
        }
}
