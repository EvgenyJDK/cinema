package com.cinema.dao.api;

import com.cinema.model.Session;
import com.cinema.model.Ticket;
import java.util.List;

public interface TicketDAO {

    List <Ticket> findAllTickets();

    void purchaseTicket (Ticket id);

    void findAllTicketsBySession (Session id);

    void deleteAllTicketsBySessionId (List<Ticket> tickets);


}
