package com.cinema.dao.impl;

import com.cinema.dao.api.TicketDAO;
import com.cinema.model.Session;
import com.cinema.model.Ticket;

import java.util.List;

/**
 * Created by Админ on 20.04.2016.
 */
public class TicketDAOMySQLImpl implements TicketDAO {


    private static TicketDAO ticketDAO = null;
    public static TicketDAO getInstance() {
        System.out.println("!!!!!!!!!!");
        System.out.println("Hello TicketDAOMySQLImpl");

//        if (userDAO==null){
//            synchronized (UserDAOMySQLImpl.class){
//                if (userDAO==null){
//                    userDAO = new UserDAOMySQLImpl();
//                }
//            }
//        }

        return ticketDAO;
    }

    @Override
    public List<Ticket> findAllTickets() {
        return null;
    }

    @Override
    public void purchaseTicket(Ticket id) {

    }

    @Override
    public void findAllTicketsBySession(Session id) {

    }

    @Override
    public void deleteAllTicketsBySessionId(List<Ticket> tickets) {

    }
}
