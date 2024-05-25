package com.campify.carsinventaire.controllers;


import com.campify.carsinventaire.config.ConfigParams;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RefreshScope
public class CarsConfigTestController {

    @Value("${cars.params.a}")
    private int p1;
    @Value("${cars.params.b}")
    private int p2;
    @Value("${global.params.x}")
    private int x;
    @Value("${global.params.y}")
    private int y;

    @Autowired
    private ConfigParams configParams;

    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){
        return Map.of("x",x,"y",y,"p1",p1,"p2",p2);
    }

    @GetMapping("/configDefault")
    public ConfigParams config(){
        return configParams;
    }
}
