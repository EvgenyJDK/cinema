package com.cinema.service.impl;

import com.cinema.Transformer;
import com.cinema.dao.api.TicketDAO;
import com.cinema.dao.impl.TicketDAOImpl;
import com.cinema.dao.impl.TicketDAOMySQLImpl;
import com.cinema.dao.storage.PropertyHolder;
import com.cinema.dto.TicketDTO;
import com.cinema.model.Ticket;
import com.cinema.service.api.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService{


    private static TicketServiceImpl ticketService;

    public static TicketServiceImpl getInstance() {                           // SiTo
        if (ticketService == null) {
            synchronized (TicketServiceImpl.class) {
                if (ticketService == null) {
                    ticketService = new TicketServiceImpl();
                }
            }
        }
        return ticketService;
    }


//    public  static TicketDAO ticketDAO;                                                // Q
//
//    static {
//        PropertyHolder.getInstance();                                               // Q
//        if (PropertyHolder.isInMemoryDB()){
//            ticketDAO = TicketDAOImpl.getInstance();
//        } else {
//            ticketDAO = TicketDAOMySQLImpl.getInstance();
//        }
//    }



//    @Override
    public List<TicketDTO> findAllTickets() {

        TicketDAO ticketDAO = new TicketDAOImpl();
        List<Ticket> allTickets = ticketDAO.findAllTickets();
        List<TicketDTO> ticketDTOs = Transformer.ListTicketToListTicketDTO(allTickets);

        return ticketDTOs;


//        List<TicketDTO> ticketDTOs = new LinkedList<>();                      LN
//        TicketDAO ticketDAO = TicketDAOImpl.getInstance();
//        List<Ticket> tickets = ticketDAO.getAllTickets();
//        ticketDTOs = Transformer.listSeatsToListSeatsDTO(tickets);
//        return ticketDTOs;

    }

    @Override
    public List<TicketDTO> getAllTicketsBySessionId(int sessionId) {
        return null;
    }

    @Override
    public void purchaseTicket(TicketDTO ticketDTO) {

        TicketDAO ticketDAO = new TicketDAOImpl();
        Ticket ticket = Transformer.ticketDtoToTicket(ticketDTO);
        ticketDAO.purchaseTicket(ticket);
    }

    @Override
    public void create(TicketDTO ticketDTO) {

    }
}



//    @Override
//    public boolean purchaseTicket(int id, int sessionId, UserDTO userDto) {
//        List<Ticket> allTickets = ticketDAO.findAllTicketsInSession(sessionId);
//        for (Ticket allTicket : allTickets) {
//            if (allTicket.getId() == id) {
//                allTicket.setCheck(true);
//                userDto.setPurchasedTicket(allTicket);
//                return true;
//            }
//        }
//        return false;
//    }
