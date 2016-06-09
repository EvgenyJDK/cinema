package com.cinema.service.api;

import com.cinema.dto.TicketDTO;

import java.util.List;

public interface TicketService {

    List<TicketDTO> findAllTickets ();

    List<TicketDTO> getAllTicketsBySessionId(int sessionId);

//    void saveTicket ();
//    void updateTicket ();



    void purchaseTicket (TicketDTO ticketDTO);             // купить билет

    void create(TicketDTO ticketDTO);

//    void deleteTicket ();

}
