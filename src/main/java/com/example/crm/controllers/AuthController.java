package com.example.crm.controllers;

import com.example.crm.dtos.LoginRequest;
import com.example.crm.dtos.LoginResponse;
import com.example.crm.entities.Utilisateurs;
import com.example.crm.repositories.UtilisateursRepo;
import com.example.crm.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UtilisateursRepo utilisateursRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        Utilisateurs utilisateur = utilisateursRepo
                .findByEmail(request.getEmail())
                .orElse(null);

        if (utilisateur == null) {

            return ResponseEntity.badRequest()
                    .body("Utilisateur introuvable");
        }

        if (!passwordEncoder.matches(
                request.getMotDePasse(),
                utilisateur.getMotDePasse())) {

            return ResponseEntity.badRequest()
                    .body("Mot de passe incorrect");
        }

        String token =
                jwtService.generateToken(utilisateur.getEmail());

        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }
}