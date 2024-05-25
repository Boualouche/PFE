    package com.campify.inventaireservice.clients;

    import com.campify.inventaireservice.models.Car;
    import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
    import org.springframework.cloud.openfeign.FeignClient;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;

    @FeignClient(name = "CARS-INVENTAIRE")
    public interface CarsRestClient {
        @GetMapping("/cars/{id}")
        @CircuitBreaker(name = "carsInventaire" , fallbackMethod = "getDefaultCar")
        Car findCarById(@PathVariable int id);

        default Car getDefaultCar(int id, Throwable throwable) {
            Car car = new Car();
            car.setId(id);
            car.setBrand("No Value");
            car.setName("No Value");
            car.setImagepath("No Value");
            car.setDimensions("No Value");
            car.setPuissance("No Value");
            car.setType("No Value");
            car.setTransmission("No Value");
            car.setDateFabrication("No Value");
            return  car;
        }

    }
