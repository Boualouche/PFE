package com.campify.carsinventaire.services.impl;

import com.campify.carsinventaire.domain.entities.CarsEntity;
import com.campify.carsinventaire.repository.CarsRepository;
import com.campify.carsinventaire.services.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@AllArgsConstructor
@Service
public class CarsServiceImpl implements CarsService {

    private CarsRepository carsRepository;

    @Override
    public CarsEntity save(CarsEntity car) {return carsRepository.save(car);}

    @Override
    public List<CarsEntity> findAll() {
        return StreamSupport.stream(carsRepository
                .findAll()
                .spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CarsEntity> findByid(int id) {return carsRepository.findById(id);}

    public boolean isExisting(int id) {
        return carsRepository.existsById(id);
    }

    @Override
    public void delete(int id) {carsRepository.deleteById(id);}

}
