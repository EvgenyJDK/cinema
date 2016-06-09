package com.cinema;

import com.cinema.dto.*;
import com.cinema.model.*;
import com.cinema.model.Ticket;
import sun.security.krb5.internal.*;

import java.util.LinkedList;
import java.util.List;

public class Transformer {


    public static List<MovieDTO> ListMovieToListMovieDTO(List<Movie> movies) {

        List<MovieDTO> movieDTOs = new LinkedList<>();
        System.out.println(movies);
        for (Movie movie : movies) {
            MovieDTO movieDTO = movieToMovieDTO(movie);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public static  MovieDTO movieToMovieDTO (Movie movie){
        MovieDTO movieDTO = new MovieDTO ();
        movieDTO.setId (movie.getId());
        movieDTO.setTitle (movie.getTitle());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setDuration(movie.getDuration());

        return movieDTO;
    }

    public static Movie movieDtoToMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setId(movieDTO.getId());
        movie.setDescription(movieDTO.getDescription());
        movie.setTitle(movieDTO.getTitle());
        movie.setDuration(movieDTO.getDuration());

        return movie;
    }


    public static List <UserDTO> ListUserToListUserDTO (List <User> users) {

    List<UserDTO> userDTOs = new LinkedList<>();

    for(User user : users){
        UserDTO userDTO = userToUserDTO(user);
        userDTOs.add(userDTO);
        }
        return userDTOs;
    }

//    public static UserDTO userToUserDTO(void userByLoginPassword) {
//    }

//    public static UserDTO userToUserDto(User allUser) {
//    return null;
//    }

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
//        userDTO.setPurchasedTicket(user.getPurchasedTicket());

//        user.setTickets(user.getTickets());       Q BD

        return userDTO;
    }

    public static User userDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setBirthday(userDTO.getBirthday());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
//        user.setPurchasedTicket(userDTO.getPurchasedTicket());

//        userDTO.setTickets(userDTO.getTickets());     Q BD

        return user;
    }



    public static List<HallDTO> ListHallToListHallDTO(List<Hall> halls) {

        List<HallDTO> hallDTOs = new LinkedList<>();
        for (Hall hall : halls) {
            HallDTO hallDTO = hallToHallDTO(hall);
            hallDTOs.add(hallDTO);
        }
       return hallDTOs;
   }

    public static HallDTO hallToHallDTO(Hall hall) {
        HallDTO hallDTO = new HallDTO();
        hallDTO.setId(hall.getId());
        hallDTO.setName(hall.getName());
        hallDTO.setQuantityOfRows(hall.getQuantityOfRows());
        hallDTO.setPlacesInRow(hall.getPlacesInRow());
        return  hallDTO;
    }

    public static Hall hallDtoToHall(HallDTO hallDTO) {
        Hall hall = new Hall();
        hall.setId(hallDTO.getId());
        hall.setName(hallDTO.getName());
        hall.setQuantityOfRows(hallDTO.getQuantityOfRows());
        hall.setPlacesInRow(hallDTO.getPlacesInRow());
        return hall;
    }


    public static List<TicketDTO> ListTicketToListTicketDTO(List<Ticket> tickets) {

        List<TicketDTO> ticketDTOs = new LinkedList<>();
        for (Ticket ticket : tickets) {
            TicketDTO ticketDTO = ticketToTicketDTO(ticket);
            ticketDTOs.add(ticketDTO);
        }
        return ticketDTOs;
    }


//    public static List<TicketDTO> listTicketsToListTicketsDTO(List <Ticket> tickets){
//        List<TicketDTO> ticketDTOs = new LinkedList<TicketDTO>();
//        for (Ticket ticket : tickets){
//            TicketDTO ticketDTO = ticketToTicketDTO(ticket);
//            ticketDTOs.add(ticketDTO);
//        }
//        return ticketDTOs;
//    }
//
//    public static List<Ticket> listTicketsDTOToListTickets(List <TicketDTO> ticketsDTO){
//        List<Ticket> tickets = new LinkedList<Ticket>();
//        for (TicketDTO ticketDTO : ticketsDTO){
//            Ticket ticket = ticketDTOToTicket(ticketDTO);
//            tickets.add(ticket);
//        }
//        return tickets;
//    }



    public static TicketDTO ticketToTicketDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setRow(ticket.getRow());
        ticketDTO.setPlace(ticket.getPlace());
//        ticketDTO.setQuantityOfRows(ticket.getQuantityOfRows());
//        ticketDTO.setPlacesInRow(ticket.getPlacesInRow());
        ticketDTO.setCheck(ticket.isCheck());
        return ticketDTO;
    }

    public static Ticket ticketDtoToTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setRow(ticketDTO.getRow());
        ticket.setPlace(ticketDTO.getPlace());
//        ticket.setQuantityOfRows(ticketDTO.getQuantityOfRows());
//        ticket.setPlacesInRow(ticketDTO.getPlacesInRow());
        ticket.setCheck(ticketDTO.isCheck());
        return ticket;
    }

    public static List<SessionDTO> ListSessionToListSessionDTO(List<Session> sessions) {

        List<SessionDTO> sessionDTOs = new LinkedList<>();
        for (Session session : sessions) {
            System.out.println("ListSessionToListSessionDTO  1st in transformer");
            SessionDTO sessionDTO = sessionToSessionDTO(session);
            sessionDTOs.add(sessionDTO);
        }
        return sessionDTOs;
    }

    public static SessionDTO sessionToSessionDTO(Session session) {

        SessionDTO sessionDTO = new SessionDTO();

        System.out.println(sessionDTO);

        sessionDTO.setId(session.getId());
        sessionDTO.setSessionDate(session.getSessionDate());
        sessionDTO.setHall(session.getHall());
        sessionDTO.setMovie(session.getMovie());
        sessionDTO.setTickets(session.getTickets());

//        sessionDTO.setMovie(movieToMovieDTO(session.getMovie()));
//        sessionDTO.setHall(hallToHallDTO(session.getHall()));
//        sessionDTO.setAllTickets(session.getTickets());             //или ticketToTicketDTO(session.getTickets()));

        System.out.println("sessionDTO = " + sessionDTO);
        return sessionDTO;
    }

    public static Session sessionDtoToSession(SessionDTO sessionDTO) {

        Session session = new Session();
        session.setId(sessionDTO.getId());
        session.setSessionDate(sessionDTO.getSessionDate());
        session.setTickets(sessionDTO.getTickets());
        session.setMovie(sessionDTO.getMovie());
        session.setHall(sessionDTO.getHall());

        return session;
    }



}
