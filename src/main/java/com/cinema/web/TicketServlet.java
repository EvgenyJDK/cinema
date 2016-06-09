package com.cinema.web;

import com.cinema.Transformer;
import com.cinema.dto.MovieDTO;
import com.cinema.dto.SessionDTO;
import com.cinema.dto.TicketDTO;
import com.cinema.model.Session;
import com.cinema.service.api.SessionService;
import com.cinema.service.api.TicketService;
import com.cinema.service.impl.SessionServiceImpl;
import com.cinema.service.impl.TicketServiceImpl;
//import com.cinema.transformer.SessionTransformer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class TicketServlet extends HttpServlet {

    public static final String SESSION_ID = "sessionID";            // тот к-рый выбрали в seance,jsp


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        System.out.println("TicketServlet In Get ");

                if (req.getParameter(SESSION_ID) != null) {
                    int selectedSession = Integer.parseInt(req.getParameter(SESSION_ID));
                    SessionService sessionService = SessionServiceImpl.getInstance();
                    SessionDTO sessionDTO = sessionService.get(selectedSession);
                    TicketService ticketService = TicketServiceImpl.getInstance();
                    List<TicketDTO> ticketDTOList = ticketService.getAllTicketsBySessionId(selectedSession);
                    req.setAttribute("ticketList", ticketDTOList);

                    System.out.println("~~~~~~~~~~");
                    req.setAttribute("session", selectedSession);
                    System.out.println("Ticket Servlet ~~~~~~~~`**************~~~~~~~~~~~~~~~");
                    System.out.println(sessionDTO.getHall());
//                    req.setAttribute("rows", 5);                                                // хардкод рядов и мест для сидения
//                    req.setAttribute("columns", 10);
                    System.out.println("Ticket Servlet get movie = " + sessionDTO.getMovie());
                    req.setAttribute("rows", sessionDTO.getHall().getQuantityOfRows());       //// TODO: 05.05.2016
                    req.setAttribute("columns", sessionDTO.getHall().getPlacesInRow());       //// TODO: 05.05.2016

                    req.getRequestDispatcher("/resources/jsp/hall.jsp").forward(req, resp);
                } else {
                    req.getSession().setAttribute("exception", "Please, select seance");
                    resp.sendRedirect(req.getHeader("Referer"));
                }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println( "Ticket Servlet doPost");

        TicketService ticketService = TicketServiceImpl.getInstance();
        Map<String, String[]> tickets = req.getParameterMap();

            List<TicketDTO> dtoList = new LinkedList<>();
            Session sess = null;
            for (String s : tickets.keySet()) {
                if (s.contains("session_id")) {
                    int sessionId = Integer.parseInt(req.getParameter("session_id"));
                    SessionService sessionService = SessionServiceImpl.getInstance();
                    SessionDTO sessionDTO = sessionService.get(sessionId);
                    sess = Transformer.sessionDtoToSession(sessionDTO);
                }else {
                    String[] numbers = s.split(" ");
                    int row = Integer.valueOf(numbers[0]);
                    int place = Integer.valueOf(numbers[1]);
                    TicketDTO ticketDTO = new TicketDTO();
                    ticketDTO.setRow(row);
                    ticketDTO.setPlace(place);
                    ticketDTO.setCheck(true);
                    dtoList.add(ticketDTO);
                }
            }

        System.out.println("Ticket Servlet do Post before for");
            for (TicketDTO ticketDTO : dtoList) {
                ticketDTO.setSession(sess);
                ticketService.create(ticketDTO);
            }

        System.out.println("Ticket Servlet do Post after for");
            req.setAttribute("entity", "ticket");
            req.setAttribute("session", sess);
            req.setAttribute("ticketList", dtoList);
        System.out.println(dtoList);


        System.out.println("Ticket Servlet doPost forwarding to info jsp");
            getServletContext().getRequestDispatcher("/resources/jsp/info.jsp").include(req, resp);

    }
}
