package com.campify.inventaireservice.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Car {
    private int id;
    private String imagepath;
    private String brand;
    private String name;
    private String dimensions;
    private String puissance;
    private String type; // luxary family suv Sport
    private String dateFabrication;
    private String transmission;
}
