package com.campify.inventaireservice;

import com.campify.inventaireservice.domain.entities.ArchiveVoitureEntity;
import com.campify.inventaireservice.repository.ArchiveVoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class InventaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventaireServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ArchiveVoitureRepository archiveVoitureRepository){

        return args -> {
            archiveVoitureRepository.save(ArchiveVoitureEntity.builder()
                    .car_id(1)
                    .couleur("Red")
                    .date_achat(new Date(2022-11-20))
                    .nbr_accident(0)
                    .disponible(true)
                    .build());
            archiveVoitureRepository.save(ArchiveVoitureEntity.builder()
                    .car_id(1)
                    .couleur("Blue")
                    .date_achat(new Date(2022-11-29))
                    .nbr_accident(0)
                    .disponible(false)
                    .build());
            archiveVoitureRepository.save(ArchiveVoitureEntity.builder()
                    .car_id(1)
                    .couleur("Gray")
                    .date_achat(new Date(2022-11-20))
                    .nbr_accident(0)
                    .disponible(true)
                    .build());
            archiveVoitureRepository.save(ArchiveVoitureEntity.builder()
                    .car_id(2)
                    .couleur("Dark")
                    .disponible(true)
                    .date_achat(new Date(2022-11-20))
                    .nbr_accident(0)
                    .build());
            archiveVoitureRepository.save(ArchiveVoitureEntity.builder()
                    .car_id(3)
                    .disponible(true)
                    .couleur("Light Blue")
                    .date_achat(new Date(2022-11-20))
                    .nbr_accident(0)
                    .build());
            archiveVoitureRepository.save(ArchiveVoitureEntity.builder()
                    .car_id(4)
                    .disponible(false)
                    .couleur("Light Purple")
                    .date_achat(new Date(2022-11-20))
                    .nbr_accident(0)
                    .build());
            archiveVoitureRepository.save(ArchiveVoitureEntity.builder()
                    .car_id(5)
                    .disponible(true)
                    .couleur("Yellow")
                    .date_achat(new Date(2022-11-20))
                    .nbr_accident(0)
                    .build());
        };
    }

}
