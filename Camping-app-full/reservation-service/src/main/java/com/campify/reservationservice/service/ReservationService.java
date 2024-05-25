package com.campify.reservationservice.service;

import com.campify.reservationservice.domain.entities.ReservationEntity;

import java.util.List;
import java.util.Optional;

public interface ReservationService {


    ReservationEntity save(ReservationEntity reservation);

    Optional<ReservationEntity> findByid(int id);

    List<ReservationEntity> findAll();

    boolean isExisting(int id);

    void delete(int id);
}
