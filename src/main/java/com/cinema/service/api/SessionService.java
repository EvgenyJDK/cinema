package com.cinema.service.api;

import com.cinema.dto.SessionDTO;
import com.cinema.dto.TicketDTO;

import java.util.List;

public interface SessionService {


    List<SessionDTO> getAllSessions ();

    List<SessionDTO> getSessionsByMovieId(int movieId);

//    SessionDTO get (selectSession);

    SessionDTO get(Integer sessionId);

    void createSession (SessionDTO session);

    List<TicketDTO> createListOfTickets(int hallDTO);


//   void deleteSession (SessionDTO session);



}
