package com.cinema.service.api;

import java.util.List;
import com.cinema.dto.HallDTO;

public interface HallService {

    List <HallDTO> findAllHalls ();

    void createHall (HallDTO hall);

    HallDTO findHallByName(String hallName);

    HallDTO deleteHall (HallDTO hallDTO);

    void deleteHallByName (String hallName);

    void deleteHall(int hall_id);


//    boolean addHall(HallDTO hallDto);
//    boolean updateHall(HallDTO hallDto);
//    boolean removeByIdHall(int id);
//    HallDTO getByIndexHall(int id);



//    void findAllHalls (HallDTO session);


}
