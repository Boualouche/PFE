package com.campify.reservationservice.security;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@AllArgsConstructor @NoArgsConstructor
public class SecurityConfig {

    private JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(csrf->csrf.disable()) //disabling the csrf since we are using a statless security option
                .headers(h->h.frameOptions(fo->fo.disable())) //let h2-console show the frames
                //permiting the acces to the following path
                .authorizeHttpRequests(ar->ar
                        .requestMatchers("/swagger-ui.html","/swagger-ui/**","/v3/**","/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/actuator/health","/reservation").permitAll()
                        .requestMatchers(HttpMethod.POST,"/reservation","/api/payment/create-checkout-session").permitAll()
                )
                //making sure that all the other paths require auth
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                .oauth2ResourceServer(o2rs->o2rs.jwt(Customizer.withDefaults()))
            .build();
    }
    //Cors Configuration to give acces to all browsers
    //If you use an api gateway you must add it s own configuration
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }

}
