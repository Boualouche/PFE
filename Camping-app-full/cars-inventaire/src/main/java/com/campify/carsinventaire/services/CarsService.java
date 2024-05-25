package com.campify.carsinventaire.services;

import com.campify.carsinventaire.domain.entities.CarsEntity;

import java.util.List;
import java.util.Optional;

public interface CarsService {


    CarsEntity save(CarsEntity car);

    List<CarsEntity> findAll();

    Optional<CarsEntity> findByid(int id);

    boolean isExisting(int id);

    void delete(int id);

}
