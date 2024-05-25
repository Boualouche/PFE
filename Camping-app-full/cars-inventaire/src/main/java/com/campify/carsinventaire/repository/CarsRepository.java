package com.campify.carsinventaire.repository;

import com.campify.carsinventaire.domain.entities.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<CarsEntity,Integer> {
}
