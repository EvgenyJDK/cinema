package com.cinema.dao.api;

import com.cinema.model.Hall;
import java.util.List;

public interface HallDAO {

    List<Hall> findAllHalls();

    Hall findHallByName(String hallName);

    void saveHall(Hall hall);

    void deleteHallByName (String hallName);

    Hall deleteHall(Hall hall);

    void deleteMovie(int hall_id);
}
