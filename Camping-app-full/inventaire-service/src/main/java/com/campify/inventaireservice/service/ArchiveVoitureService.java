package com.campify.inventaireservice.service;

import com.campify.inventaireservice.domain.entities.ArchiveVoitureEntity;

import java.util.List;
import java.util.Optional;

public interface ArchiveVoitureService {


    ArchiveVoitureEntity save(ArchiveVoitureEntity voiture);

    Optional<ArchiveVoitureEntity> findByid(Long id);

    List<ArchiveVoitureEntity> findAll();

    List<ArchiveVoitureEntity> findArchivedCarsByCarid(int id);

    boolean isExisting(Long id);

    void delete(Long id);


}
