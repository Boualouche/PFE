package com.campify.carsinventaire.model;

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
    private Long id;
    private Long car_id; // Service Cars
    private Integer nbr_accident;
    private Date date_achat;
    private String couleur;
}
