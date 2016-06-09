package com.cinema.web;

import com.cinema.dto.HallDTO;
import com.cinema.service.api.HallService;
import com.cinema.service.impl.HallServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Админ on 08.05.2016.
 */
public class HallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HallService hallService = HallServiceImpl.getInstance();

                if (true) {
                    System.out.println("HallServlet doGet");
                List<HallDTO> hallDTOList;
                hallDTOList = hallService.findAllHalls();
                    System.out.println("hallDTOList = " + hallDTOList);
                request.setAttribute("hallList", hallDTOList);
                request.getRequestDispatcher("/resources/jsp/hallToRemove.jsp").forward(request, response);
            } else {
                response.sendRedirect("/films");
            }
    }
}
