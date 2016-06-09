package com.cinema.service.impl;


import com.cinema.Transformer;

import com.cinema.dao.api.HallDAO;
import com.cinema.dao.impl.HallDAOImpl;
import com.cinema.dao.impl.HallDAOMySQLImpl;
import com.cinema.dto.HallDTO;
import com.cinema.model.Hall;
import com.cinema.service.api.HallService;

import java.util.List;

public class HallServiceImpl implements HallService {


    private static HallServiceImpl hallService;                         // LN

    public static HallServiceImpl getInstance() {
        if (hallService == null) {
            synchronized (HallServiceImpl.class) {
                if (hallService == null) {
                    hallService = new HallServiceImpl();
                }
            }
        }
        return hallService;
    }

    public List<HallDTO> findAllHalls() {
//        HallDAO hallDAO = new HallDAOImpl();
        HallDAO hallDAO = new HallDAOMySQLImpl();
        List<Hall> allHalls = hallDAO.findAllHalls();
        List<HallDTO> hallDTOs = Transformer.ListHallToListHallDTO(allHalls);
        return hallDTOs;
    }

    @Override
    public void createHall(HallDTO hallDto) {
        System.out.println("HallServiceImpl createHall");
//        HallDAO hallDAO = new HallDAOImpl();
        HallDAO hallDAO = new HallDAOMySQLImpl();
        Hall hall = Transformer.hallDtoToHall(hallDto);
        hallDAO.saveHall(hall);
     }

    @Override
    public HallDTO findHallByName(String hallName) {
//        HallDAO hallDAO = new HallDAOImpl();
        HallDAO hallDAO = new HallDAOMySQLImpl();
        Hall hall = hallDAO.findHallByName(hallName);
//        return Transformer.hallToHallDTO(hall);

        HallDTO hallDTO = null;
        if(hall != null) {
            hallDTO = Transformer.hallToHallDTO(hall);
        }
        return hallDTO;
    }


    @Override
    public HallDTO deleteHall(HallDTO hallDTO) {
        HallDAO hallDAO = HallDAOImpl.getInstance();
        Hall hall = hallDAO.deleteHall(Transformer.hallDtoToHall(hallDTO));
        return Transformer.hallToHallDTO(hall);
    }


    @Override
    public void deleteHallByName(String hallName) {
        HallDAO hallDAO = new HallDAOImpl();
        hallDAO.deleteHallByName(hallName);

    }

    @Override
    public void deleteHall(int hall_id) {

        HallDAO movieDAO = new HallDAOMySQLImpl();
        movieDAO.deleteMovie(hall_id);
    }


//
//    @Override
//    public void findAllHalls(HallDTO session) {
//
//    }


}
