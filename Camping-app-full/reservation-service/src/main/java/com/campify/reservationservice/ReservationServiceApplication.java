package com.campify.reservationservice;

import com.campify.reservationservice.domain.entities.PaymentMethod;
import com.campify.reservationservice.domain.entities.ReservationEntity;
import com.campify.reservationservice.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
@EnableFeignClients
@SpringBootApplication
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ReservationRepository reservationRepository) {
        return args -> {
            reservationRepository.save(ReservationEntity.builder()
                    .date_debut_reservation(new Date(2023-5-1))
                    .date_fin_reservation(new Date(2023-5-10))
                    .location_emportation("Location A")
                    .location_retour("Location B")
                    .nomClient("John Doe")
                    .ageClient(30)
                    .addressClient("123 Main St, Cityville")
                    .paymentMethod(PaymentMethod.INTERNET)
                    .build());

            reservationRepository.save(ReservationEntity.builder()
                    .date_debut_reservation(new Date(2023-6-15))
                    .date_fin_reservation(new Date(2023-6-20))
                    .location_emportation("Location C")
                    .location_retour("Location D")
                    .nomClient("Jane Smith")
                    .ageClient(25)
                    .addressClient("456 Elm St, Townsville")
                    .paymentMethod(PaymentMethod.INTERNET)
                    .build());

            reservationRepository.save(ReservationEntity.builder()
                    .date_debut_reservation(new Date(2023-7-1))
                    .date_fin_reservation(new Date(2023-7-5))
                    .location_emportation("Location E")
                    .location_retour("Location F")
                    .nomClient("Alice Johnson")
                    .ageClient(28)
                    .addressClient("789 Oak St, Villageville")
                    .paymentMethod(PaymentMethod.INTERNET)
                    .build());

            reservationRepository.save(ReservationEntity.builder()
                    .date_debut_reservation(new Date(2023-8-10))
                    .date_fin_reservation(new Date(2023-8-15))
                    .location_emportation("Location G")
                    .location_retour("Location H")
                    .nomClient("Bob Brown")
                    .ageClient(35)
                    .addressClient("321 Pine St, Hamletville")
                    .paymentMethod(PaymentMethod.INTERNET)
                    .build());

            reservationRepository.save(ReservationEntity.builder()
                    .date_debut_reservation(new Date(2023-9-20))
                    .date_fin_reservation(new Date(2023-9-25))
                    .location_emportation("Location I")
                    .location_retour("Location J")
                    .nomClient("Carol White")
                    .ageClient(32)
                    .addressClient("654 Maple St, Boroughville")
                    .paymentMethod(PaymentMethod.INTERNET)
                    .build());
        };
    }

}
