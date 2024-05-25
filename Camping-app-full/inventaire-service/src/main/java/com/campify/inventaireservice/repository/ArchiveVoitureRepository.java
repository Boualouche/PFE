package com.campify.inventaireservice.repository;

import com.campify.inventaireservice.domain.entities.ArchiveVoitureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ArchiveVoitureRepository extends JpaRepository<ArchiveVoitureEntity, Long> {
    @Query("SELECT a FROM ArchiveVoitureEntity a WHERE a.car_id = :carId")
    List<ArchiveVoitureEntity> findByCarId(@Param("carId") int carId);
}
