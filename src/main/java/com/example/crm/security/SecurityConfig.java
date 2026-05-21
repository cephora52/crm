package com.example.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                // Désactiver CSRF
                .csrf(csrf -> csrf.disable())

                // Gestion des autorisations
                .authorizeHttpRequests(auth -> auth

                        // Routes publiques
                        .requestMatchers(

                                "/api/auth/**",

                                "/api/utilisateurs/**",
                                "/api/clients/**",
                                "/api/interactions/**",
                                "/api/campagnes/**",

                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/swagger-ui/index.html",

                                "/v3/api-docs",
                                "/v3/api-docs/**",

                                "/error"

                        ).permitAll()

                        // Toutes les autres routes sécurisées
                        .anyRequest().authenticated()
                )

                // Session stateless pour JWT
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                );

        // Ajouter filtre JWT
        http.addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config)
            throws Exception {

        return config.getAuthenticationManager();
    }
}