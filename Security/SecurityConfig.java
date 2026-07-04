package com.tailoringmanagementsystem.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.List;



@Configuration
public class SecurityConfig {



@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {



    http.csrf(csrf -> csrf.disable())
    .cors(cors -> cors.configurationSource(corsConfigurationSource()))
    .authorizeHttpRequests(auth -> auth
        .requestMatchers(
                    "/user/signup",
                    "/user/login",
                    "/user/forgot-password",
                     "/user/verify-otp",
                     "/user/reset-password",
                    "/user/**",
                    "/api/auth/**")
        .permitAll()
        .requestMatchers("/api/makeup-customers/**")
        .permitAll()
        .requestMatchers("/api/makeup-services/**")
        .permitAll()
        .requestMatchers("/api/makeup-bookings/**")
        .permitAll()
        .requestMatchers("/api/makeup/customers/**")
        .permitAll()
        .requestMatchers( "/api/makeup/**" )
        .permitAll()
        .requestMatchers( "/api/measurements/**" )
        .permitAll()
        .requestMatchers("/api/orders/**","/api/vieworders/**" )
        .permitAll()
        .requestMatchers("/api/dashboard/**")
        .permitAll()
        .requestMatchers(
            "/css/**",
            "/js/**",
            "/html/**"
        )
        .permitAll()
        .anyRequest()
        .permitAll()
    );
    return http.build();
}

@Bean
public CorsConfigurationSource corsConfigurationSource(){
    CorsConfiguration config =new CorsConfiguration();
    config.setAllowedOrigins( List.of("http://127.0.0.1:5500", "http://localhost:5500"));
    config.setAllowedMethods( List.of( "GET", "POST", "PUT", "DELETE", "OPTIONS")
    );
    config.setAllowedHeaders(List.of("*"));
    config.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**",config);
    return source;

}

}