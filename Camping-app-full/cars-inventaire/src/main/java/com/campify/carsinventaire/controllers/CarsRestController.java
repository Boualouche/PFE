package com.campify.carsinventaire.controllers;


import com.campify.carsinventaire.clients.InventaireRestClient;
import com.campify.carsinventaire.domain.dto.CarsDto;
import com.campify.carsinventaire.domain.entities.CarsEntity;
import com.campify.carsinventaire.mappers.Mapper;
import com.campify.carsinventaire.model.Inventaire;
import com.campify.carsinventaire.services.CarsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class CarsRestController {

    private CarsService carsService;

    private InventaireRestClient inventaireRestClient;

    private Mapper<CarsEntity, CarsDto> carsMapper;

    @GetMapping
    public List<CarsDto> carsList(){
        List<CarsEntity> cars = carsService.findAll();
        return cars.stream()
                .map(carsMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/inventaire")
    public List<CarsDto> carsInventaireList(){
        List<CarsEntity> cars = carsService.findAll();

        cars.forEach(carsEntity ->{
            carsEntity.setInventaire(inventaireRestClient.listInventaireByVoiture(carsEntity.getId()));
        });

        return cars.stream()
                .map(carsMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarsDto> getCarsById(@PathVariable("id") int id ){
        Optional<CarsEntity> car = carsService.findByid(id);
        return car.map(carsEntity -> {
            CarsDto carsDto =carsMapper.mapTo(carsEntity);
            return new ResponseEntity<>(carsDto , HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)) ;
    }

    @PostMapping
    public ResponseEntity<CarsDto> createCar(@Valid @RequestBody CarsDto car ){
        CarsEntity carEntity = carsMapper.mapFrom(car);
        CarsEntity savedcarEntity = carsService.save(carEntity);
        return new ResponseEntity(car,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarsDto> updateFullCar(
            @PathVariable("id") int id,
            @RequestBody CarsDto carsDto)
    {
        if(!carsService.isExisting(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        carsDto.setId(id);
        CarsEntity car = carsMapper.mapFrom(carsDto);
        CarsEntity savedCar = carsService.save(car);

        return new ResponseEntity<>(carsMapper.mapTo(savedCar),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(
            @PathVariable("id") int id
    ){
        carsService.delete(id);
        return new ResponseEntity("Car id :"+id+" deleted with success",HttpStatus.NO_CONTENT);
    }

}
