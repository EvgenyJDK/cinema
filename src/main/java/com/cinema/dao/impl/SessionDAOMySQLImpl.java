package com.cinema.dao.impl;

import com.cinema.dao.api.SessionDAO;
import com.cinema.datasource.DataSource;
import com.cinema.model.Hall;
import com.cinema.model.Movie;
import com.cinema.model.Session;
import com.cinema.model.Ticket;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Админ on 20.04.2016.
 */
public class SessionDAOMySQLImpl implements SessionDAO {

    private static SessionDAO sessionDAO = null;

    public static SessionDAO getInstance() {
        System.out.println("!!!!!!!!!!");
        System.out.println("Hello SessionDAOMySQLImpl");

//        if (userDAO==null){
//            synchronized (UserDAOMySQLImpl.class){
//                if (userDAO==null){
//                    userDAO = new UserDAOMySQLImpl();
//                }
//            }
//        }
        return sessionDAO;
    }



    public static final String FIND_BY_ID = "SELECT * FROM %s WHERE id =?";
    public static final String FIND_SESSION_BY_MOVIE_ID = "SELECT * FROM cinema.session WHERE movie_id =?";

    protected DataSource dataSource;



    @Override
    public List<Session> findAllSessions() {
        return null;
    }

    @Override
    public List<Session> findSessionByMovieId(int movieId) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Session> result = null;
        try {
            PreparedStatement preparedStatement = createSelectStatement(connection, movieId);
            ResultSet sessionRS = preparedStatement.executeQuery();
            result = readAllSessions(sessionRS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public Session get(Integer sessionId) {

        Session session = null;
        Connection connection = null;

        try {
            connection = DataSource.getInstance().getConnection();
//            Statement statement = connection.createStatement();
//            System.out.println("SessionDAOMySQLImpl select from cinema.session");


            // ПРЯМАЯ ВЫБОРКА ВСЕХ SESSION_ID

//            ResultSet resultSet = statement.executeQuery("Select * from cinema.session");
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int movieId = resultSet.getInt("movie_id");
//                int hallId = resultSet.getInt("hall_id");
////                int hallId = resultSet.getInt(hall_id);
////            String name = resultSet.getString(2);
//            System.out.println("id = " + id);
//                System.out.println("movieId = " + movieId);
//                System.out.println("hall_Id = " + hallId);
////            System.out.println(name);
//                session = new Session();
//                session.setId(id);
//                session.setMovie(movieId);
//                session.setHall(hallId);
//
//                System.out.println("session = " + session);
////        return session;
//           }
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        return session;



//          PREPARED STATEMENT

//        public T get(S id) {
            String sql = String.format(FIND_BY_ID, "cinema.session");
//            Connection connection = dataSource.getConnection();
//            T entity = null;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, (Integer) sessionId);
                ResultSet resultSet = preparedStatement.executeQuery();

                session = readOne(resultSet);
                System.out.println("SessionDAOMySQLImpl = " + session);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return session;
        }



    private Session readOne(ResultSet resultSet) throws SQLException {
        Session result = null;
        while (resultSet.next()) {
            Session session = mapSession(resultSet);
            result = session;
        }
        return result;
    }


    private PreparedStatement createSelectStatement(Connection connection, int movie_id) throws SQLException {
        PreparedStatement preparedStatement;

        String sessionSQL = String.format(FIND_SESSION_BY_MOVIE_ID);
        preparedStatement = connection.prepareStatement(sessionSQL);
        preparedStatement.setInt(1, movie_id);
        return preparedStatement;
    }

    private List<Session> readAllSessions(ResultSet resultSet) throws SQLException {
        List<Session> result = new LinkedList<>();
        while (resultSet.next()) {
            Session session = mapSession(resultSet);
            result.add(session);
        }
        return result;
    }

    protected Session mapSession(ResultSet resultSet) throws SQLException {
        Session session = new Session();
        System.out.println(session);
        session.setId(resultSet.getInt("id"));
        session.setMovie(loadMovieById(resultSet.getInt("movie_id")));

        System.out.println("SessionDAOMySQLImpl loadMovieById = " + loadMovieById(resultSet.getInt("movie_id")));

        session.setHall(loadHallById(resultSet.getInt("hall_id")));

        System.out.println("SessionDAOMySQLImpl loadHallById = " + loadHallById(resultSet.getInt("hall_id")));
        System.out.println("mapSession = " + session);

        return session;
    }

    private Movie loadMovieById(int movie_id) {
        String sql = String.format(FIND_BY_ID, "cinema.movie");
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Movie result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, movie_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = mapMovie(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected Movie mapMovie(ResultSet resultSet) throws SQLException {
        Movie movie = null;
        if(resultSet.getRow() > 0) {
            movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setDescription(resultSet.getString("description"));
            movie.setDuration(resultSet.getLong("duration"));
        }
        return movie;
    }


    private Hall loadHallById(int hall_id) {

        String sql = String.format(FIND_BY_ID, "cinema.hall");

        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Hall result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, hall_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = mapHall(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    protected Hall mapHall(ResultSet resultSet) throws SQLException {
        Hall hall = null;
        if(resultSet.getRow() > 0) {
            hall = new Hall();
            hall.setId(resultSet.getInt("id"));
            hall.setName(resultSet.getString("name"));
            hall.setQuantityOfRows(resultSet.getInt("rowCount"));
            hall.setPlacesInRow(resultSet.getInt("columnCount"));
        }
        return hall;
    }


    @Override
    public void createSession(Session session) {

    }

    @Override
    public List<Ticket> createListOfTickets(int hallId) {
        return null;
    }

    @Override
    public void deleteSession(int id) {

    }
}
