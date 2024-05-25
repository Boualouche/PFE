package com.campify.carsinventaire.mappers.impl;

import com.campify.carsinventaire.domain.dto.CarsDto;
import com.campify.carsinventaire.domain.entities.CarsEntity;
import com.campify.carsinventaire.mappers.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class CarsMapper implements Mapper<CarsEntity, CarsDto> {


    private ModelMapper modelMapper ;

    @Override
    public CarsDto mapTo(CarsEntity carsEntity) {return modelMapper.map(carsEntity,CarsDto.class);}

    @Override
    public CarsEntity mapFrom(CarsDto carsDto) {return modelMapper.map(carsDto,CarsEntity.class);}
}
