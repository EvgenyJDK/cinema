package com.cinema.dao.impl;

import com.cinema.dao.api.MovieDAO;
import com.cinema.dao.storage.InMemoryDB;
import com.cinema.dao.storage.PropertyHolder;
import com.cinema.dto.MovieDTO;
import com.cinema.model.Movie;
import java.util.List;


public class MovieDAOImpl implements MovieDAO {


    private static MovieDAOImpl movieDAOInMemory;                                   // LN

    public static MovieDAOImpl getInstance() {
        if (movieDAOInMemory == null) {
            synchronized (MovieDAOImpl.class) {
                if (movieDAOInMemory == null) {
                    movieDAOInMemory = new MovieDAOImpl();
                }
            }
        }
        return movieDAOInMemory;
    }

    public List<Movie> findAllMovies() {

//        System.out.println(movies);
//      if (PropertyHolder.getInstance().getDatabase()) {	            // проверка inMemoryDB или MySQL
//            return null;
//        } else {
        InMemoryDB instance = InMemoryDB.getInstance();
        List<Movie> movies = instance.fetchAllMovies();
        return movies;
    }

    @Override
    public void saveMovie(Movie movie) {
        if (PropertyHolder.getInstance().isInMemoryDB()) {                // проверка inMemoryDB или MySQL
        } else {
            InMemoryDB instance = InMemoryDB.getInstance();
            instance.saveMovie(movie);
        }
    }

    @Override
    public void updateMovie(Movie movie) {
        if (PropertyHolder.getInstance().isInMemoryDB()) {
        } else {
            InMemoryDB instance = InMemoryDB.getInstance();
            instance.saveMovie(movie);
        }

    }

    @Override
    public void deleteMovie(Movie movie) {
        if (PropertyHolder.getInstance().isInMemoryDB()) {
        } else {
            InMemoryDB instance = InMemoryDB.getInstance();
            instance.deleteMovie(movie);
        }
    }

    @Override
    public void deleteMovie(int movie_id) {

    }

    //    @Override
//    public void updateMovie(MovieDTO movie) {
//        InMemoryDB instance = InMemoryDB.getInstance();
//        instance.updateMovie(movie);
//    }
//
//    @Override
//    public void deleteMovie(Movie movieToDelete) {
//        InMemoryDB instance = InMemoryDB.getInstance();
//        instance.deleteMovie(movieToDelete);
//    }




}
