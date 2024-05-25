package com.campify.reservationservice.repository;

import com.campify.reservationservice.domain.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity , Integer> {

}
