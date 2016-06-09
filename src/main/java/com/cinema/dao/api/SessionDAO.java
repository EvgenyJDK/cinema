package com.cinema.dao.api;

import com.cinema.model.Session;
import com.cinema.model.Ticket;

import java.util.List;

public interface SessionDAO {

    List<Session> findAllSessions();

    List<Session> findSessionByMovieId(int movieId);

    Session get(Integer sessionId);

    void createSession(Session session);

    List<Ticket> createListOfTickets(int hallId);

    void deleteSession(int id);



}
