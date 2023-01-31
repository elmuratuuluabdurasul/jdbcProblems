package org.example.dao;

import org.example.model.Restourant;

import java.util.List;

public interface RestourantDao {

    //create
    void createTable();

    //save
    void saveRestourant(Restourant restourant);

    //findById
    Restourant findById(Long id);

    // getALl
    List<Restourant> getAllRestourants();


    //update
    void updateRestourant(Long ResoourantId, Restourant newRestourant);


    //delete
    void deleteRestourants();
}
