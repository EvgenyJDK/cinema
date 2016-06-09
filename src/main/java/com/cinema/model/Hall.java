package com.cinema.model;


public class Hall {

    private int id;
    private String name;
    private int QuantityOfRows;
    private int placesInRow;

    public Hall(int id, String name, int QuantityOfRows, int placesInRow) {                 // этот конструктор никем не вызывается ??????????
        this.id = id;
        this.name = name;
        this.QuantityOfRows = QuantityOfRows;
        this.placesInRow = placesInRow;
    }


    public Hall () {

    }


    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", QuantityOfRows=" + QuantityOfRows +
                ", placesInRow=" + placesInRow +
                '}';
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getQuantityOfRows() { return QuantityOfRows; }

    public void setQuantityOfRows(int quantityOfRows) { this.QuantityOfRows = quantityOfRows; }

    public int getPlacesInRow() { return placesInRow; }

    public void setPlacesInRow(int placesInRow) { this.placesInRow = placesInRow; }

}
