package com.cinema.dao.storage;

import com.cinema.dto.HallDTO;
import com.cinema.dto.MovieDTO;
import com.cinema.model.*;
import com.cinema.service.api.HallService;
import com.cinema.service.impl.HallServiceImpl;

import java.util.LinkedList;
import java.util.List;

public final class InMemoryDB {

   // private static InMemoryDB inMemoryDB = new InMemoryDB();

    private static InMemoryDB inMemoryDB;

    private List<Movie> movies = new LinkedList<>();
    private int movieIdsCounter = 0;

    private List<User> users = new LinkedList<>();
    private int userIdsCounter = 0;

    private List<Hall> halls = new LinkedList<>();
    private int hallIdsCounter = 0;

    private List<Session> sessions = new LinkedList<>();
    private int sessionIdsCounter = 0;

    private List<Ticket> tickets = new LinkedList<>();
    private int ticketIdsCounter = 0;


    private  InMemoryDB (){
    }

    public static InMemoryDB getInstance () {                           // SiTo Q
       synchronized ( InMemoryDB.class) {
           if (inMemoryDB == null) {
               inMemoryDB = new InMemoryDB();
           }
       }
        return inMemoryDB;
    }


    public List<Movie> fetchAllMovies () { return movies; }
    public List<User> fetchAllUsers () { return users; }
    public List<Hall> fetchAllHalls () { return halls; }
    public List<Session> fetchAllSessions () { return sessions; }
    public List<Ticket> fetchAllTickets () { return tickets; }


    public void saveMovie(Movie movie) {                                //   Movie Q
        movie.setId(++movieIdsCounter);
        movies.add(movie);
    }

    public void updateMovie (MovieDTO movieUpdate) {                    // MovieDTO Q
        for (Movie movie : movies) {
            if (movie.equals(movieUpdate)) {
                movie.setTitle(movieUpdate.getTitle());
                movie.setDescription(movieUpdate.getDescription());
                movie.setDuration(movieUpdate.getDuration());
            }
        }
    }

    public void deleteMovie (Movie movieToDelete){                        //  Movie Q
        System.out.println("*****DELETE IN MEMEORYDB******");
        System.out.println("To DELETE " + movieToDelete);
        System.out.println(movies);
        synchronized (movies) {                                         // synhronized
            for (Movie movie : movies) {
                System.out.println(movie);
                System.out.println(movie.equals(movieToDelete));        // false
                if (true) {
//                if (movie.equals(movieToDelete)) {                      //  false, remove
                    System.out.println("*****IN FOR******");
                    movies.remove(movieToDelete);                               // remove Q
                    System.out.println(movies);
                    break;
                }
                System.out.println("****OUT OF FOR*******");
            }
        }
//        return (Movie) movies;
    }


                                                                        // LN
     public void saveUser(User user) {                                  // throws UserLoginException {
         synchronized (users) {                                         // synhronized
             user.setId(++userIdsCounter);
             users.add(user);
         }
     }


    public User findUserByLoginPassword (String login, String password){
        User user = null;
        for (User eachUser : users) {
            if (eachUser.getLogin().equals(login) && eachUser.getPassword().equals(password))
                user = eachUser;
        }
//        if (user == null)throw new IncorrectLoginOrPasswordException ();
//        System.out.println("found " + user);
        return user;
    }

    public void deleteUserByID(int userID) {
        System.out.println(userID);
        for (User user : users) {
            System.out.println("user id = " + user.getId());
            if (user.getId() == userID) {
                System.out.println(user.getId() == userID);
                synchronized (user) {
                    users.remove(user);
                }
            }
        }
    }


    public void saveHall(Hall hall) {
        hall.setId(++hallIdsCounter);
        halls.add(hall);
    }


    public Hall deleteHall(Hall hallToDelete) {
        synchronized (halls) {
        for (Hall eachHall : halls) {
            if (eachHall.equals(hallToDelete)) {
                System.out.println("Delete check " + (eachHall.equals(hallToDelete)));
                     halls.remove(hallToDelete);
                 }
            }
        }
        return hallToDelete;
    }

    public void deleteHallByName(String hallName) {
        System.out.println(hallName);
        for (Hall hall : halls) {
            System.out.println("hallName = " + hall.getName());
            if (hall.getName() == hallName) {
                System.out.println(hall.getName() == hallName);
                synchronized (hall) {
                    halls.remove(hall);
                }
            }
        }
    }



    public void purchaseTicket(Ticket ticket) {
        ticket.setId(++ticketIdsCounter);
        tickets.add(ticket);
    }

// при создании session создать все билеты под заданный hall, по умолчанию false (не куплены)
//    НО НЕ ОБЯЗАТЕЛЬНО ЭТО ДЕЛАТЬ

    public List<Ticket> fillAllTicketList(int hallId) {

        HallService hallService = new HallServiceImpl();
        List<HallDTO> halls = hallService.findAllHalls();
        for (HallDTO hall : halls) {
            //        for (Session session : sessions) {
            if (hall.getId() == hallId) {

                for (int i = 1; i <= hall.getQuantityOfRows(); i++) {
                    for (int j = 1; j <= hall.getPlacesInRow(); j++) {
                        tickets.add(new Ticket(++ticketIdsCounter, i, j, false));
                    }
                }
            }
        }
        return tickets;
    }


    public void createSession(Session session) {
        session.setId(++sessionIdsCounter);
        sessions.add(session);
    }

}


