package com.cinema.web;

import com.cinema.dto.MovieDTO;
import com.cinema.dto.SessionDTO;
//import com.cinema.model.enums.RoleEnum;
import com.cinema.model.Role;
import com.cinema.service.api.MovieService;
import com.cinema.service.api.SessionService;
import com.cinema.service.impl.MovieServiceImpl;
import com.cinema.service.impl.SessionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class MovieServlet extends HttpServlet {

    private final String MOVIE_ID = "selected_movie";       // выбранный movie из films.jsp

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Movie servlet");
        MovieService movieService = MovieServiceImpl.getInstance();
        List<MovieDTO> movie;                                               //

        System.out.println("Movie servlet before get all movies");
                movie = movieService.getAllMovies();                            // TODO пока так
        System.out.println("Movie servlet get all movies");

                HttpSession session = req.getSession();
                session.setAttribute("action", "films");
                session.setAttribute("method", "post");
                req.setAttribute("filmList", movie);
                req.getRequestDispatcher("/resources/jsp/films.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userRole  = (String) req.getSession().getAttribute("userRole");
        SessionService sessionService = SessionServiceImpl.getInstance();

        if(req.getParameter(MOVIE_ID) != null) {
            int selectedMovie_id = Integer.parseInt(req.getParameter(MOVIE_ID));
            if (userRole == Role.ADMIN.name()) {

            } else {
                List<SessionDTO> sessionDTOList = sessionService.getSessionsByMovieId(selectedMovie_id);
                System.out.println("Movie Servlet do Post before get session");
//                List<SessionDTO> sessionDTOList = sessionService.getAllSessions();
                req.setAttribute("sessionList", sessionDTOList);
                req.getRequestDispatcher("resources/jsp/seance.jsp").forward(req, resp);
            }
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/films");
            PrintWriter out= resp.getWriter();
            out.println("<font color=red>Please select movie</font>");
            rd.include(req, resp);
        }
    }
}
