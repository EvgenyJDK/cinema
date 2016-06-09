package com.cinema.dao.api;

import com.cinema.dto.MovieDTO;
import com.cinema.model.Movie;
import java.util.List;


public interface MovieDAO {

    List <Movie> findAllMovies();

    void saveMovie(Movie movie);

//    void updateMovie(MovieDTO movie);           // MovieDTO Q
    void updateMovie(Movie movie);

    void deleteMovie (Movie movie);             //  Movie Q

    void deleteMovie(int movie_id);
}
