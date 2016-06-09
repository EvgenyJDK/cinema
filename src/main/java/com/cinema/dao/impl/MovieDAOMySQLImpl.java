package com.cinema.dao.impl;


import com.cinema.dao.api.MovieDAO;
import com.cinema.datasource.DataSource;
import com.cinema.model.Movie;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MovieDAOMySQLImpl implements MovieDAO {

    public static final String INSERT_MOVIE = "INSERT INTO movie (title, description, duration) values (?,?,?)";
    public static final String SELECT_ALL = "SELECT * FROM movie";
    public static final String DELETE = "DELETE FROM %s WHERE id =?";


    @Override
    public List<Movie> findAllMovies() {


        // ПРЯМАЯ ВЫБОРКА

        Connection connection = null;
//        List result = null;
        List<Movie> resultList = new LinkedList<>();

        try {
            connection = DataSource.getInstance().getConnection();

            Statement statement = connection.createStatement();
            System.out.println("MovieDAOMySQLImpl select from cinema.movie");
            ResultSet resultSet = statement.executeQuery("Select * from cinema.movie");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                System.out.println(id);
                System.out.println(name);

                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getLong("duration"));
                resultList.add(movie);
            }

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  resultList;











//          PREPARED STATEMENT

//        PreparedStatement preparedStatement;
//
//
////        String sql = String.format(SELECT_ALL, "cinema." + stringMap.get(entityClass));
////        Connection connection = dataSource.getConnection();
//
//        List result = null;
//        try {
//            preparedStatement = connection.prepareStatement(SELECT_ALL, Statement.RETURN_GENERATED_KEYS);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            result = readAll(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
////      return null;
//    }
//
//    private List<Movie> readAll(ResultSet resultSet) throws SQLException {
//        List<Movie> resultList = new LinkedList<>();
//        while (resultSet.next()) {
//            Movie movie = mapMovie(resultSet);
//            resultList.add(movie);
//            break;
//        }
//        return  resultList;
//    }
//
//    protected Movie mapMovie(ResultSet resultSet) throws SQLException {
//        Movie movie = null;
////        if(resultSet.getRow() > 0) {
//        if (true) {
//            movie = new Movie();
//            movie.setId(resultSet.getInt("id"));
//            movie.setTitle(resultSet.getString("title"));
//            movie.setDescription(resultSet.getString("description"));
//            movie.setDuration(resultSet.getLong("duration"));
////            movie.setRating(resultSet.getDouble("rating"));
//            System.out.println("map movie");
//        }
//        return movie;
    }





    @Override
    public void saveMovie(Movie movie) {

            System.out.println("MovieDAOMySQLImpl savemovie");
            Connection connection = null;

            try {
                connection = DataSource.getInstance().getConnection();
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(connection);
            System.out.println("MovieDAOMySQLImpl try to insert");



            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setString(2, movie.getDescription());
                preparedStatement.setLong(3, movie.getDuration());
                preparedStatement.executeUpdate();

                ResultSet movieResultSet = preparedStatement.getGeneratedKeys();
                movieResultSet.next();
                movie.setId(movieResultSet.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void updateMovie(Movie movie) {

    }

    @Override
    public void deleteMovie(Movie movie) {

    }

    @Override
    public void deleteMovie(int movie_id) {

        Connection connection;              // = null;

        try {
            connection = DataSource.getInstance().getConnection();
            createDeleteStatement(connection, movie_id);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        private void createDeleteStatement(Connection connection, int movie_id) throws SQLException {
            PreparedStatement preparedStatement;

                    preparedStatement = connection.prepareStatement("DELETE FROM ticket where session_id=" + "ANY (SELECT session.id FROM session WHERE movie_id=?);");
                    preparedStatement.setInt(1, movie_id);
                    preparedStatement.executeUpdate();

                    preparedStatement = connection.prepareStatement("DELETE FROM session where movie_id=?");
                    preparedStatement.setInt(1, movie_id);
                    preparedStatement.executeUpdate();

                    String movieSQL = String.format(DELETE, "cinema.movie");
                    preparedStatement = connection.prepareStatement(movieSQL);
                    preparedStatement.setInt(1, movie_id);
                    preparedStatement.executeUpdate();
    }
    }
