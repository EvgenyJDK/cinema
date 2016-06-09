package com.cinema.model;

import com.cinema.dto.HallDTO;
import sun.security.krb5.internal.Ticket;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 21.03.2016.
 */
public class Session {

    private  int id;
    private LocalDate sessionDate;
    private Movie movie;                       // добавить
    private Hall hall;
    private List <Ticket> tickets;             // список всех билетов, привязанных к конкретному hall
    private int movieId;
    private int hallId;


    public Session(int id, LocalDate sessionDate, List<Ticket> tickets, Movie movie, Hall hall) {            // Q
        this.id = id;
        this.sessionDate = sessionDate;
        this.tickets = tickets;
        this.movie = movie;
        this.hall = hall;
    }

    public Session() {                              //  вызывается Transformer.sessionDtoToSession
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", sessionDate=" + sessionDate +
                ", tickets=" + tickets +
                ", hall=" + hall +
                '}';
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getSessionDate() { return sessionDate; }
    public void setSessionDate(LocalDate sessionDate) { this.sessionDate = sessionDate; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public List<Ticket> getTickets() { return tickets; }
    public void setTickets() { List <Ticket> tickets; }
    public void setTickets(List<Ticket> tickets) {   }

    public Hall getHall() { return hall; }
    public void setHall(Hall hall) { this.hall = hall; }


//    public void setMovie(int movieId) {
//        System.out.println("in the session setter");
//        System.out.println(movieId);
//        this.movieId = movieId;
//    }
//
//    public void setHall(int hallId) {
//        System.out.println("in the session setter hallid");
//        System.out.println(hallId);
//        this.hallId = hallId;
//    }
}


//    public void setTickets(List<Ticket> tickets) {
//    }




//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Session session = (Session) o;
//
//        return id.equals(session.id);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }




