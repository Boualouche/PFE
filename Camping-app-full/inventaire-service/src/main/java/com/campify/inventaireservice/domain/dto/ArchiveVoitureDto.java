package com.campify.inventaireservice.domain.dto;

import com.campify.inventaireservice.models.Car;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArchiveVoitureDto {
    private Long id;
    @NotBlank(message = "The car_id must not be null")
    private int car_id; // Service Cars
    private Integer nbr_accident;
    @NotBlank(message = "The date must not be null")
    private Date date_achat;
    @NotBlank(message = "The color must not be null")
    private String couleur;
    private boolean disponible;
    private Car car;
}
