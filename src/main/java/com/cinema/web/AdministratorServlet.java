package com.cinema.web;

import com.cinema.dto.HallDTO;
import com.cinema.dto.MovieDTO;
import com.cinema.model.AdminRights;
import com.cinema.model.Role;
import com.cinema.service.api.HallService;
import com.cinema.service.api.MovieService;
import com.cinema.service.api.SessionService;
import com.cinema.service.impl.HallServiceImpl;
import com.cinema.service.impl.MovieServiceImpl;
import com.cinema.service.impl.SessionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Админ on 03.05.2016.
 */
public class AdministratorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//       if (true) {
            req.getRequestDispatcher("/resources/jsp/administratorHomePage.jsp").forward(req, resp);
//        }else{
//            resp.sendRedirect("/films");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userRole  = (String) req.getSession().getAttribute("userRole"); //
        if(userRole == Role.ADMIN.name()) {
            String action = req.getParameter("action");
            HttpSession session = req.getSession(false);
            System.out.println("admin servlet");


            switch (AdminRights.getType(action)) {
                case ADD_FILM:
                    System.out.println("enum ADD FILM");
                    session.setAttribute("action", "addFilm");
                    session.setAttribute("method", "get");

                    resp.sendRedirect("/resources/jsp/addFilm.jsp");
                    break;
                case SHOW_ALL_FILMS:
                    System.out.println("show all films");
                    session.setAttribute("action", "allFilms");
                    session.setAttribute("method", "get");
//                    resp.sendRedirect("/resources/jsp/films.jsp");
                    resp.sendRedirect("/movie");
                    break;


                case REMOVE_FILM:
                    System.out.println("Administration Servlet remove Film");
                    session.setAttribute("action", "deleteFilm");
//                    session.setAttribute("action", "removeFilm");
                    session.setAttribute("method", "post");

                    MovieService movieService = MovieServiceImpl.getInstance();
                    List<MovieDTO> filmList;
                    filmList = movieService.getAllMovies();
                    req.setAttribute("filmList", filmList);                     // передаем filmList в filmToRemove.jsp
                    req.getRequestDispatcher("/resources/jsp/filmToRemove.jsp").forward(req, resp);
                    break;

                case ADD_HALL:
                    session.setAttribute("action", "addHall");
                    session.setAttribute("method", "get");
//                    resp.sendRedirect("/addHall");
                    resp.sendRedirect("/resources/jsp/addHall.jsp");
                    break;
                case SHOW_ALL_HALLS:
                    System.out.println("Administration Servlet show all halls");
                    session.setAttribute("action", "allHalls");
                    session.setAttribute("method", "get");
//                    resp.sendRedirect("/resources/jsp/halls.jsp");
                    resp.sendRedirect("/hall");
                    break;

//                case EDIT_HALL:
//                    resp.sendRedirect("/addFilm");
//                    break;

                case REMOVE_HALL:
                    System.out.println("Administration Servlet remove Hall");
                    session.setAttribute("action", "deleteHall");
                    session.setAttribute("method", "post");

                    HallService hallService = HallServiceImpl.getInstance();
                    List<HallDTO> hallDTOList;
                    hallDTOList = hallService.findAllHalls();
                    System.out.println("IN ADMIN.SERVLET hallDTOList = " + hallDTOList);
                    req.setAttribute("hallList", hallDTOList);         // передаем hallList в hallToRemove.jsp
                    req.getRequestDispatcher("/resources/jsp/hallToRemove.jsp").forward(req, resp);


            }
        }else{
            req.getRequestDispatcher("/resources/jsp/films.jsp").forward(req, resp);
        }
    }



}



//                case EDIT_FILM:
//                    session.setAttribute("action", "editFilm");
//                    session.setAttribute("method", "get");
//                    resp.sendRedirect("/films");
//                    break;
//                case ADD_HALL_TO_FILM:
//                    session.setAttribute("action", "addHallToFilm");
//                    resp.sendRedirect("/films");
//                    break;


//                case DELETE_HALL:
//                    resp.sendRedirect("/addFilm");
//                    break;
//                case ADD_SEANS:
//                    resp.sendRedirect("/addFilm");
//                    break;
//                case EDIT_SEANS:
//                    resp.sendRedirect("/addFilm");
//                    break;
//                case DELETE_SEANS:
//                    resp.sendRedirect("/addFilm");
//                    break;