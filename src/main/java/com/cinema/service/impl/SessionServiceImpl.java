package com.cinema.service.impl;


import com.cinema.Transformer;
import com.cinema.dao.api.SessionDAO;
import com.cinema.dao.impl.SessionDAOImpl;
import com.cinema.dao.impl.SessionDAOMySQLImpl;
import com.cinema.dto.SessionDTO;
import com.cinema.dto.TicketDTO;
import com.cinema.model.Session;
import com.cinema.model.Ticket;
import com.cinema.service.api.SessionService;

import java.util.List;

public class SessionServiceImpl implements SessionService{

    private static SessionServiceImpl sessionService;

    public static SessionServiceImpl getInstance() {                           // SiTo
        if (sessionService == null) {
            synchronized (SessionServiceImpl.class) {
                if (sessionService == null) {
                    sessionService = new SessionServiceImpl();
                }
            }
        }
        return sessionService;
    }


//    SessionDAO sessionDAO = dbKind();                             // BG Создаем обьект базы данных
//    public SessionDAO  dbKind(){
//        try {
//            if(PropertiesHolder.getInstance().getProperty()=="mysql"){
//                sessionDAO=new SessionDAOMySQLImpl();
//            }
//            else{
//                sessionDAO = new SessionDAOInMemoryImpl();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("PropertiesHolder IOEXCEPTION(");
//        }
//        return sessionDAO;
//    }



    @Override
    public List<SessionDTO> getAllSessions() {
        SessionDAO sessionDAO = new SessionDAOImpl();                           // хардкод вкл. базы инмемори
        List<Session> allSessions = sessionDAO.findAllSessions();
        List<SessionDTO> sessionDTOs = Transformer.ListSessionToListSessionDTO(allSessions);
        return sessionDTOs;
    }

    @Override
    public List<SessionDTO> getSessionsByMovieId(int movieId) {

//        SessionDAO sessionDAO = new SessionDAOImpl();
        SessionDAO sessionDAO = new SessionDAOMySQLImpl();
        List<Session> sessionByMovie = sessionDAO.findSessionByMovieId(movieId);
        List<SessionDTO> sessionDTOs = Transformer.ListSessionToListSessionDTO(sessionByMovie);
        return sessionDTOs;

//        public List<SessionDTO> getSessionsByMovieId(int movie_id) {
//            SessionCrudDAO sessionDAO;
//            if(!PropertyReader.getInstance().isInMemoryDB()) {
//                sessionDAO = SessionCrudDAOInMemoryImpl.getInstance();
//            }else {
//                sessionDAO = SessionCrudDAOImpl.getInstance();
//            }
//            List<Session> session = sessionDAO.getSessionsByMovieId(movie_id);
//            List<SessionDTO> result = SessionTransformer.sessionTosessionDTO(session);
//            return result;


    }

    @Override
    public SessionDTO get(Integer sessionId) {

//        SessionDAO sessionDAO = new SessionDAOImpl();
        SessionDAO sessionDAO = new SessionDAOMySQLImpl();

//    public SessionDTO get(Integer sessionId) {
//        SessionCrudDAO sessionDAO;
//        if(!PropertyReader.getInstance().isInMemoryDB()) {
//            sessionDAO = SessionCrudDAOInMemoryImpl.getInstance();
//        }else {
//            sessionDAO = SessionCrudDAOImpl.getInstance();
//        }
        Session session = sessionDAO.get(sessionId);
        SessionDTO result = Transformer.sessionToSessionDTO(session);
        return result;


    }

    @Override
    public void createSession(SessionDTO sessionDto) {
        SessionDAO sessionDAO = new SessionDAOImpl();                           // хардкод вкл. базы инмемори
        Session session = Transformer.sessionDtoToSession(sessionDto);
        sessionDAO.createSession(session);
    }



    @Override
    public List<TicketDTO> createListOfTickets(int hallDTO) {                       // (int hallId)
        SessionDAO sessionDAO = new SessionDAOImpl();                               // хардкод вкл. базы инмемори
        List<Ticket> allTickets = sessionDAO.createListOfTickets(hallDTO);          //  createListOfTickets(hallId);
        List<TicketDTO> ticketDTOs = Transformer.ListTicketToListTicketDTO(allTickets);
        SessionService sessionService = new SessionServiceImpl();
        List<SessionDTO> sessions = sessionService.getAllSessions();
        for (SessionDTO session : sessions) {
            if (session.getId()== hallDTO) {
//                session.setTickets(allTickets);                                     // Q
                System.out.println("SessionServiceImpl createListOfTickets");
            }
        }
        return ticketDTOs;
    }


    //    @Override
    public void deleteSession(SessionDTO session) {

    }
}
