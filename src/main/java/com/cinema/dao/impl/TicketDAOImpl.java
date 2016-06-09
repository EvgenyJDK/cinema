package com.cinema.dao.impl;


import com.cinema.dao.api.TicketDAO;
import com.cinema.dao.storage.InMemoryDB;
import com.cinema.model.Session;
import com.cinema.model.Ticket;

import java.util.List;

public class TicketDAOImpl implements TicketDAO{


    private static TicketDAOImpl ticketDAOInMemory;

    public static TicketDAOImpl getInstance(){
        if (ticketDAOInMemory == null){
            synchronized (TicketDAOImpl.class) {
                if (ticketDAOInMemory == null){
                    ticketDAOInMemory = new TicketDAOImpl();
                }
            }
        }
        return ticketDAOInMemory;
    }


    @Override
    public List<Ticket> findAllTickets() {

        InMemoryDB instance = InMemoryDB.getInstance();
        List<Ticket> tickets = instance.fetchAllTickets();
        return tickets;
    }

    @Override
    public void purchaseTicket(Ticket ticket) {

        InMemoryDB instance = InMemoryDB.getInstance();
        instance.purchaseTicket(ticket);
    }


    @Override
    public void findAllTicketsBySession(Session id) {

    }

    @Override
    public void deleteAllTicketsBySessionId(List<Ticket> tickets) {

    }
}
