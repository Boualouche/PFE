    package com.campify.reservationservice.clients;

    import com.campify.reservationservice.models.Inventaire;
    import com.fasterxml.jackson.databind.JsonSerializer;
    import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
    import org.springframework.cloud.openfeign.FeignClient;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;

    import java.util.Date;

    @FeignClient(name = "INVENTAIRE-SERVICE")
    public interface InventaireRestClient {
        @GetMapping("/inventaire/{id}")
        @CircuitBreaker(name = "inventaireService" , fallbackMethod = "getDefaultInventaire")
        Inventaire findInventaireById(@PathVariable int id);

        default Inventaire getDefaultInventaire(int id, Throwable throwable) {
            Inventaire inventaire = new Inventaire();
            inventaire.setCar_id(0);
            inventaire.setCouleur("No value");
            inventaire.setId(id);
            inventaire.setDate_achat(new Date());
            inventaire.setNbr_accident(0);
            inventaire.setDisponible(false);
            return  inventaire;
        }

    }
