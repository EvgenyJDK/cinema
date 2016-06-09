package com.cinema.dto;


public class HallDTO {

    private int id;
    private String name;
    private int quantityOfRows;
    private int placesInRow;

    public HallDTO (int id, String name, int quantityOfRows, int placesInRow) {
        this.id = id;
        this.name = name;
        this.quantityOfRows = quantityOfRows;
        this.placesInRow = placesInRow;
    }


    public HallDTO () {                                         // вызывает Transformer.HallToHallDTO
    }


    @Override
    public String toString() {
        return "HallDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityOfRows=" + quantityOfRows +
                ", placesInRow=" + placesInRow +
                '}';
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getQuantityOfRows() { return quantityOfRows; }

    public void setQuantityOfRows(int quantityOfRows) { this.quantityOfRows = quantityOfRows; }

    public int getPlacesInRow() { return placesInRow; }

    public void setPlacesInRow(int placesInRow) { this.placesInRow = placesInRow; }

}
