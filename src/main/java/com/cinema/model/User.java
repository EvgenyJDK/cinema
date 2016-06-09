package com.cinema.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
//    private Date birthday;
    private LocalDate birthday;      // Q
    private String email;
    private List<Ticket> purchasedTickets; //show how tickets get on hand user
    private Role role;

    public User(int id, String firstName, String lastName, String login, String password, int year, int month, int day, String email, Role role) {
//    public User(int id, String firstName, String lastName, String login, String password, Date birthday, String email, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
//        this.birthday = birthday;
        setBirthday(year, month, day);
        this.email = email;
        setRole(role);
    }

    public User() {                                 //  вызывается Transformer.userDtoToUser
    }

    public User(String firstName, String lastName, String email, String login, String password) {
    }


    @Override
    public String toString() {
        return null;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(int year, int month, int day) {
        birthday = LocalDate.of(year, month, day);
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

//    public Date getBirthday() { return birthday; }
//    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

//    public List<Ticket> getPurchasedTicket() { return purchasedTickets; }
//    public void setPurchasedTicket(List<Ticket> purchasedTickets) {purchasedTickets.add((Ticket) purchasedTickets);    }

//    public void setPurchasedTickets(List<Ticket> purchasedTickets) { this.purchasedTickets = purchasedTickets; }
//    public void setPurchasedTicket(Ticket purchasedTicket) { purchasedTickets.add(purchasedTicket); }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }


}
