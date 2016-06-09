package com.cinema.dto;

import com.cinema.model.Hall;
import com.cinema.model.Movie;
import sun.security.krb5.internal.Ticket;

import java.time.LocalDate;
import java.util.List;


public class SessionDTO {

    private  int id;
    private LocalDate sessionDate;
    private Movie movie;
    private MovieDTO movieDTO;
    private HallDTO hallDTO;
    private Hall hall;
    private List<Ticket> tickets;
    private List<TicketDTO> allTickets;


//    public SessionDTO (int id, int year, int month, int day, List<Ticket> tickets, Hall hall) {
//        this.id = id;
//        setSessionDate(year, month, day);
//        this.tickets = tickets;
//        this.hall = hall;
//    }


    public SessionDTO () {                                          // вызывает Transformer.sessionToSessionDTO
    }

    public SessionDTO(int id, int year, int month, int day, MovieDTO movieDTO, HallDTO hallDTO) {           // , List<TicketDTO> allTickets)
        this.id = id;
        setSessionDate(year, month, day);
        setMovieDTO(movieDTO);
//        this.allTickets = allTickets;
        this.hallDTO = hallDTO;
    }

    @Override
    public String toString() {
        return "SessionDTO{" +
                "id=" + id +
                ", sessionDate=" + sessionDate +
                ", movieDTO=" + movieDTO +
                ", hallDTO=" + hall +
//                ", hall=" + hall +
//                ", tickets=" + tickets +
                ", allTickets=" + allTickets +
                '}';
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getSessionDate() { return sessionDate; }
    public void setSessionDate(LocalDate sessionDate) { this.sessionDate = sessionDate; }
    public void setSessionDate(int year, int month, int day) { this.sessionDate = LocalDate.of(year, month, day); }

//    public Date getSessionDate() { return sessionDate; }
//    public void setSessionDate(Date sessionDate) { this.sessionDate = sessionDate; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public void setMovieDTO(MovieDTO movieDTO) { this.movieDTO = movieDTO; }

    public HallDTO getHallDTO() { return hallDTO; }
    public void setHallDTO(HallDTO hallDTO) { this.hallDTO = hallDTO; }
//    public void setHall(Hall hall) { this.hallDTO = hallDTO; }

    public Hall getHall() { return hall; }
    public void setHall(Hall hall) { this.hall = hall; }


    public void setAllTickets(List<Ticket> tickets) {    }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }

    public List<TicketDTO> getAllTickets() { return allTickets; }

    public List<Ticket> getTickets() {
        return tickets;
    }


//    public void setAllTickets(List<TicketDTO> allTickets) { this.allTickets = allTickets; }



//    public List<Ticket> getTickets() { return tickets; }

}

