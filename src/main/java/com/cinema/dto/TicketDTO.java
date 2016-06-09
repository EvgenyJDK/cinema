package com.cinema.dto;


import com.cinema.model.Session;

public class TicketDTO {


    private int id;
    private Session session;
    private int row;
    private int place;
    private boolean check;

    public TicketDTO(int id, Session session, int row, int place, boolean check) {
        this.id = id;
        this.session = session;
        this.row = row;
        this.place = place;
        this.check = check;
    }

//    public TicketDTO(int i, int i1, int i2, boolean b) {            // для main
//    }

    public TicketDTO () {                           // вызывает Transformer.ticketToTicketDTO
    }




    @Override
    public String toString() {
        return "TicketDTO {" +
                "id=" + id +
                ", row=" + row +
                ", place=" + place +
                ", check=" + check +
                '}';
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getRow() { return row; }

    public void setRow(int row) { this.row = row; }

    public int getPlace() { return place; }

    public void setPlace(int place) { this.place = place; }

    public boolean isCheck() { return check; }

    public void setCheck(boolean check) { this.check = check; }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


}
