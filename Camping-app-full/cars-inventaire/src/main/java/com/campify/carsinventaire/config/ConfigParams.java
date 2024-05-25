package com.campify.carsinventaire.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
@ConfigurationProperties(prefix = "global.params")
public class ConfigParams {

    private int x;

    private int y;
}
