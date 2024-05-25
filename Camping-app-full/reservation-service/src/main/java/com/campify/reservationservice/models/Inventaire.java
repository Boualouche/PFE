package com.campify.reservationservice.models;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Inventaire {
    private int id;
    private int car_id; // Service Cars
    private Integer nbr_accident;
    private Date date_achat;
    private String couleur;
    private boolean disponible;
}
