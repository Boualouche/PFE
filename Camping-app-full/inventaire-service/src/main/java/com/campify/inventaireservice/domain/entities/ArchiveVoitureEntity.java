package com.campify.inventaireservice.domain.entities;


import com.campify.inventaireservice.models.Car;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class ArchiveVoitureEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int car_id; // Service Cars
    private Integer nbr_accident;
    private Date date_achat;
    private String couleur;
    private boolean disponible;
    @Transient
    private Car car;
}
