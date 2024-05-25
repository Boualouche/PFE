package com.campify.reservationservice.domain.dto;

import com.campify.reservationservice.domain.entities.PaymentMethod;
import com.campify.reservationservice.models.Inventaire;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class ReservationDto {

    private int id;
    private int inventaire_id;
    private Date date_debut_reservation;
    private Date date_fin_reservation;
    private String location_emportation;
    private String location_retour;
    private String nomClient;
    private int ageClient;
    private String addressClient;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Inventaire inventaire;
}
