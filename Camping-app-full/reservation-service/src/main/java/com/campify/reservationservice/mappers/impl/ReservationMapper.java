package com.campify.reservationservice.mappers.impl;


import com.campify.reservationservice.domain.dto.ReservationDto;
import com.campify.reservationservice.domain.entities.ReservationEntity;
import com.campify.reservationservice.mappers.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationMapper implements Mapper<ReservationEntity, ReservationDto> {

    private ModelMapper modelMapper;

    @Override
    public ReservationDto mapTo(ReservationEntity reservationEntity) {
        return modelMapper.map(reservationEntity, ReservationDto.class);
    }

    @Override
    public ReservationEntity mapFrom(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, ReservationEntity.class);
    }
}
