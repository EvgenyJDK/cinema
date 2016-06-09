package com.cinema.web;

import com.cinema.service.api.MovieService;
import com.cinema.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Админ on 05.05.2016.
 */
public class RemoveMovieServlet extends HttpServlet {


    public static final String MOVIE_ID = "movieID";
    public static final String FILM_ID = "filmID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Remove Movie Servlet doGet");
        resp.sendRedirect("/films");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Remove Movie Servlet doPost");
        MovieService movieService = MovieServiceImpl.getInstance();

                    int movie_id = Integer.parseInt(request.getParameter(FILM_ID));

                    System.out.println("Remove Movie Servlet = " + movie_id);
                    movieService.deleteMovie(movie_id);
                    response.sendRedirect("/administration");


    }

}
