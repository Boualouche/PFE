package com.campify.reservationservice.domain.entities;


import com.campify.reservationservice.models.Inventaire;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class ReservationEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Transient
    private Inventaire inventaire;

}
