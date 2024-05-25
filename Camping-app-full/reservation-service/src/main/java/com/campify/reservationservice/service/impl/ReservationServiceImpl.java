package com.campify.reservationservice.service.impl;

import com.campify.reservationservice.domain.entities.ReservationEntity;
import com.campify.reservationservice.repository.ReservationRepository;
import com.campify.reservationservice.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    @Override
    public ReservationEntity save(ReservationEntity reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Optional<ReservationEntity> findByid(int id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<ReservationEntity> findAll() {
        return StreamSupport.stream(reservationRepository
                .findAll()
                .spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExisting(int id) {
        return reservationRepository.existsById(id);
    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);
    }
}
