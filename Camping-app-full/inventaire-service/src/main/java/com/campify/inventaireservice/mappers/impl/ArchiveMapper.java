package com.campify.inventaireservice.mappers.impl;

import com.campify.inventaireservice.domain.dto.ArchiveVoitureDto;
import com.campify.inventaireservice.domain.entities.ArchiveVoitureEntity;
import com.campify.inventaireservice.mappers.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ArchiveMapper implements Mapper<ArchiveVoitureEntity, ArchiveVoitureDto> {

    private ModelMapper modelMapper;
    @Override
    public ArchiveVoitureDto mapTo(ArchiveVoitureEntity archiveVoitureEntity) {return modelMapper.map(archiveVoitureEntity, ArchiveVoitureDto.class); }

    @Override
    public ArchiveVoitureEntity mapFrom(ArchiveVoitureDto archiveVoitureDto) {return modelMapper.map(archiveVoitureDto, ArchiveVoitureEntity.class);}
}
