package com.cinema.model;

/**
 * Created by User on 24.03.2016.
 */
public class Ticket {

    private int id;
    private int row;
    private int place;
    private boolean check;


    public Ticket(int id, int row, int place, boolean check) {          // Q
        this.id = id;
        this.row = row;
        this.place = place;
        this.check = check;
    }

    public Ticket() {                   //  вызывается Transformer.ticketDtoToTicket
     }


    @Override
    public String toString() {
        return "Ticket{" +
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


}
