package com.cinema.service.api;

import com.cinema.dto.MovieDTO;
import java.util.List;


public interface MovieService {

    List <MovieDTO> getAllMovies ();

    void createMovie (MovieDTO movie);

    void updateMovie (MovieDTO movie);

    void deleteMovie (MovieDTO movie);

    void deleteMovie(int movie_id);
}
