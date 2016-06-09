package com.cinema.dao.impl;

import com.cinema.dao.api.SessionDAO;
import com.cinema.dao.storage.InMemoryDB;
import com.cinema.model.Session;
import com.cinema.model.Ticket;

import java.util.List;

public class SessionDAOImpl implements SessionDAO{


    private static SessionDAOImpl sessionDAOInMemory;

    public static SessionDAOImpl getInstance(){
        if (sessionDAOInMemory == null){
            synchronized (SessionDAOImpl.class) {
                if (sessionDAOInMemory == null){
                    sessionDAOInMemory = new SessionDAOImpl();
                }
            }
        }
        return sessionDAOInMemory;
    }


    public List<Session> findAllSessions() {
        InMemoryDB instance = InMemoryDB.getInstance();
        System.out.println("Session DAO Impl");
        List<Session> sessions = instance.fetchAllSessions();
        return sessions;
    }

    @Override
    public List<Session> findSessionByMovieId(int movieId) {
        return null;
    }



    @Override
    public Session get(Integer sessionId) {
        return null;
    }



    @Override
    public void createSession(Session session) {
            InMemoryDB instance = InMemoryDB.getInstance();
        instance.createSession(session);
    }


    @Override
    public List<Ticket> createListOfTickets(int hallId) {

        InMemoryDB instance = InMemoryDB.getInstance();

        List<Ticket> tickets = instance.fillAllTicketList(hallId);

        instance = InMemoryDB.getInstance();
        List<Session> sessions = instance.fetchAllSessions();
        for (Session session : sessions) {
            if (session.getId() == hallId) {
                session.setTickets();                               //.setTickets(tickets);
            }
        }
        return tickets;

    }


    @Override
    public void deleteSession(int id) {
    }

}
