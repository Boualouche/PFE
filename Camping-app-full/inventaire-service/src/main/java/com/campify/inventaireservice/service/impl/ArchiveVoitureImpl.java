package com.campify.inventaireservice.service.impl;

import com.campify.inventaireservice.domain.entities.ArchiveVoitureEntity;
import com.campify.inventaireservice.repository.ArchiveVoitureRepository;
import com.campify.inventaireservice.service.ArchiveVoitureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@AllArgsConstructor
public class ArchiveVoitureImpl implements ArchiveVoitureService {

    private ArchiveVoitureRepository archiveVoitureRepository;

    @Override
    public ArchiveVoitureEntity save(ArchiveVoitureEntity voiture) {return archiveVoitureRepository.save(voiture);}

    public Optional<ArchiveVoitureEntity> findByid(Long id) {return archiveVoitureRepository.findById(id);}

    @Override
    public List<ArchiveVoitureEntity> findAll() {
        return StreamSupport.stream(archiveVoitureRepository
                        .findAll()
                        .spliterator(),false)
                .collect(Collectors.toList());
    }


    @Override
    public List<ArchiveVoitureEntity> findArchivedCarsByCarid(int id) {
        return archiveVoitureRepository.findByCarId(id);
    }

    public boolean isExisting(Long id) {
        return archiveVoitureRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {archiveVoitureRepository.deleteById(id);}

}
