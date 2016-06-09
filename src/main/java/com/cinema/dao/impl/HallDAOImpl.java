package com.cinema.dao.impl;


import com.cinema.dao.api.HallDAO;
import com.cinema.dao.storage.InMemoryDB;
import com.cinema.dao.storage.PropertyHolder;
import com.cinema.model.Hall;
import java.util.List;


public class HallDAOImpl implements HallDAO {

    private static HallDAOImpl hallDAOInMemory;                                   // LN

    public static HallDAOImpl getInstance() {
        if (hallDAOInMemory == null) {
            synchronized (HallDAOImpl.class) {
                if (hallDAOInMemory == null) {
                    hallDAOInMemory = new HallDAOImpl();
                }
            }
        }
        return hallDAOInMemory;
    }


    @Override
    public List<Hall> findAllHalls() {
//        if (PropertyHolder.getInstance().getDatabase()) {                 // LN
//            return null;
//        } else {
        InMemoryDB instance = InMemoryDB.getInstance();
        List<Hall> halls = instance.fetchAllHalls();
        return halls;
//        }
    }

    @Override
    public Hall findHallByName(String hallName) {
        return null;
    }


    @Override
    public void saveHall(Hall hall) {
        InMemoryDB instance = InMemoryDB.getInstance();
        instance.saveHall(hall);
    }


    @Override
    public void deleteHallByName(String hallName) {
        InMemoryDB instance = InMemoryDB.getInstance();
        instance.deleteHallByName(hallName);
    }


    @Override
    public Hall deleteHall(Hall hallToDelete) {
        if (PropertyHolder.getInstance().isInMemoryDB()) {
            return null;
        } else {
            InMemoryDB instance = InMemoryDB.getInstance();
            return instance.deleteHall(hallToDelete);
        }
    }

    @Override
    public void deleteMovie(int hall_id) {

    }


}
