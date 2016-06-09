package com.cinema.service.impl;

import com.cinema.Transformer;
//import com.cinema.dao.api.MovieDAO;
//import com.cinema.dao.api.MovieDAO;
//import com.cinema.dao.impl.MovieDAOInMemoryImpl;
//import com.cinema.dao.api.MovieDAO;
//import com.cinema.dao.impl.MovieDAOInMemoryImpl;


import com.cinema.dao.api.MovieDAO;
import com.cinema.dao.impl.MovieDAOImpl;
//import com.cinema.dao.impl.MovieDAOInMemoryImpl;
import com.cinema.dao.impl.MovieDAOMySQLImpl;
import com.cinema.dto.MovieDTO;
import com.cinema.model.Movie;
import com.cinema.service.api.MovieService;
import java.util.List;

public class MovieServiceImpl implements MovieService {

    // почему не Override ??????

    private static MovieServiceImpl movieService;                         // LN

    public static MovieServiceImpl getInstance() {                           // SiTo
        if (movieService == null) {
            synchronized (MovieServiceImpl.class) {
                if (movieService == null) {
                    movieService = new MovieServiceImpl();
                }
            }
        }
        return movieService;
    }




     public List <MovieDTO> getAllMovies () {

//     MovieDAO movieDAO = new MovieDAOImpl();
     MovieDAO movieDAO = new MovieDAOMySQLImpl();
     List <Movie> allMovies = movieDAO.findAllMovies();
     List <MovieDTO> movieDTOs = Transformer.ListMovieToListMovieDTO(allMovies);
     return movieDTOs;
 }

    @Override
    public void createMovie(MovieDTO movieDto) {

//        MovieDAO movieDAO = new MovieDAOImpl();
        MovieDAO movieDAO = new MovieDAOMySQLImpl();
        Movie movie = Transformer.movieDtoToMovie(movieDto);
        movieDAO.saveMovie(movie);
    }

    @Override
    public void updateMovie(MovieDTO movieDto) {

        MovieDAO movieDAO = new MovieDAOImpl();
        Movie movie = Transformer.movieDtoToMovie(movieDto);
        movieDAO.updateMovie(movie);

//        Movie movie = Transformer.movieDtoToMovie(movieDTO);
//        return Transformer.movieToMovieDTO(movieDAO.updateMovie(movie));

    }

    @Override
    public void deleteMovie(MovieDTO movieDto) {

       MovieDAO movieDAO = new MovieDAOImpl();
//     MovieDAO movieDAO = new MovieDAOInMemoryImpl();
       Movie movie = Transformer.movieDtoToMovie(movieDto);
       movieDAO.deleteMovie(movie);

    }

    @Override
    public void deleteMovie(int movie_id) {

//        MovieDAO movieDAO = new MovieDAOImpl();
        MovieDAO movieDAO = new MovieDAOMySQLImpl();
        movieDAO.deleteMovie(movie_id);
    }

}
