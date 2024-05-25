package com.campify.carsinventaire.domain.dto;


import com.campify.carsinventaire.model.Inventaire;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CarsDto {

        private int id;
        @Pattern(regexp = "^path/to/\\w+\\.jpg$")
        private String imagepath;
        @NotBlank(message = "The Brand must not be null")
        private String brand;
        @NotBlank(message = "The Name must not be null")
        private String name;
        @NotBlank(message = "The Dimension must not be null")
        private String dimensions;
        @NotBlank(message = "The Power must not be null")
        private String puissance;

        private List<Inventaire> inventaire;
        @NotBlank(message = "The Type must not be null")
        private String type; // luxary family suv Sport
        @NotBlank(message = "The Date must not be null")
        private String dateFabrication;
        @NotBlank(message = "The Transmission must not be null")
        private String transmission;
}