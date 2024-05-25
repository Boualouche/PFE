package com.campify.inventaireservice.controller;

import com.campify.inventaireservice.clients.CarsRestClient;
import com.campify.inventaireservice.domain.dto.ArchiveVoitureDto;
import com.campify.inventaireservice.domain.entities.ArchiveVoitureEntity;
import com.campify.inventaireservice.mappers.Mapper;
import com.campify.inventaireservice.models.Car;
import com.campify.inventaireservice.service.ArchiveVoitureService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/inventaire")
@AllArgsConstructor
public class ArchiveVoitureController {

    private CarsRestClient carsRestClient;

    private ArchiveVoitureService archiveVoitureService;

    private Mapper<ArchiveVoitureEntity, ArchiveVoitureDto> archiveMapper;


    @GetMapping
    public List<ArchiveVoitureDto> voitureList(){
        List<ArchiveVoitureEntity> allVoiture = archiveVoitureService.findAll();
        return allVoiture.stream()
                .map(archiveMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchiveVoitureDto> getInventaireById(@PathVariable("id") Long id) {
        Optional<ArchiveVoitureEntity> archiveVoitureOptional = archiveVoitureService.findByid(id);
        if (archiveVoitureOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ArchiveVoitureEntity archiveVoiture = archiveVoitureOptional.get();
        try {
            Car car = carsRestClient.findCarById(archiveVoiture.getCar_id());
            archiveVoiture.setCar(car);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        ArchiveVoitureDto inventaireDTO = archiveMapper.mapTo(archiveVoiture);
        return ResponseEntity.ok(inventaireDTO);
    }


    @GetMapping("/cars/{id}")
    public List<ArchiveVoitureDto> listInventaireByVoiture(@PathVariable int id){
        List<ArchiveVoitureEntity> allVoiture = archiveVoitureService.findArchivedCarsByCarid(id);
        return allVoiture.stream()
                .map(archiveMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ArchiveVoitureDto> createCar(@Valid @RequestBody ArchiveVoitureDto carDTO ){
        ArchiveVoitureEntity car = archiveMapper.mapFrom(carDTO);
        ArchiveVoitureEntity savedcar = archiveVoitureService.save(car);
        return new ResponseEntity(car, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArchiveVoitureDto> updateFullCar(
            @PathVariable("id") Long id,
            @RequestBody ArchiveVoitureDto carsDto)
    {
        if(!archiveVoitureService.isExisting(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        carsDto.setId(id);
        ArchiveVoitureEntity car = archiveMapper.mapFrom(carsDto);
        ArchiveVoitureEntity savedCar = archiveVoitureService.save(car);

        return new ResponseEntity<>(archiveMapper.mapTo(savedCar),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(
            @PathVariable("id") Long id
    ){
        archiveVoitureService.delete(id);
        return new ResponseEntity("Inventaire id :"+id+" deleted with success",HttpStatus.NO_CONTENT);
    }


}
