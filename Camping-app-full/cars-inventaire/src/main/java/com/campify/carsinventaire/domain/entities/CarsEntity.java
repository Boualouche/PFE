package com.campify.carsinventaire.domain.entities;


import com.campify.carsinventaire.model.Inventaire;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "cars")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class CarsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imagepath;
    private String brand;
    private String name;
    private String dimensions;
    private String puissance;
    @Transient
    private List<Inventaire>inventaire;
    private String type; // luxary family suv Sport
    private String dateFabrication;
    private String transmission;
}
