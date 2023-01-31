package org.example.service;

import org.example.dao.RestourantDao;
import org.example.dao.RestourantDaoImpl;
import org.example.model.Restourant;

import java.util.List;

public class RestourantServiceImpl implements RestourantService{
    RestourantDao restourantDao = new RestourantDaoImpl();
    @Override
    public void createTable() {
        restourantDao.createTable();
    }

    @Override
    public void saveRestourant(Restourant restourant) {
        restourantDao.saveRestourant(restourant);
    }

    @Override
    public Restourant findById(Long id) {
        return restourantDao.findById(id);
    }

    @Override
    public List<Restourant> getAllRestourants() {
        return restourantDao.getAllRestourants();
    }

    @Override
    public void updateRestourant(Long resoourantId, Restourant newRestourant) {
        restourantDao.updateRestourant(resoourantId,newRestourant);
    }

    @Override
    public void deleteRestourants() {
        restourantDao.deleteRestourants();

    }
}
