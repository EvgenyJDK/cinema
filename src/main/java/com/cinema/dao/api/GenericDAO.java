package com.cinema.dao.api;


import java.util.List;

public interface  GenericDAO <T, K> {

    List<T> findAll ();
    void create ( T t);
    void update (T t);
    void delete (T t);

}
