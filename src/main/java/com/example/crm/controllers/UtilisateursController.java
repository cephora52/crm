package com.example.crm.controllers;

import com.example.crm.services.interfaces.UtilisateursInterface;
import com.mycompany.crm.dtos.UtilisateursDto;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin("*")
public class UtilisateursController {

    @Autowired
    private UtilisateursInterface utilisateursInterface;

    @GetMapping
    public List<UtilisateursDto> getAllUtilisateurs() {

        return utilisateursInterface.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateursDto> getUtilisateurById(@PathVariable Long id) {

        Optional<UtilisateursDto> utilisateur = utilisateursInterface.getUtilisateurById(id);

        return utilisateur.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UtilisateursDto> createUtilisateur(
            @RequestBody UtilisateursDto utilisateursDto) {

        return ResponseEntity.ok(
                utilisateursInterface.createUtilisateur(utilisateursDto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateursDto> updateUtilisateur(
            @PathVariable Long id,
            @RequestBody UtilisateursDto utilisateursDto) {

        return ResponseEntity.ok(
                utilisateursInterface.updateUtilisateur(id, utilisateursDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {

        utilisateursInterface.deleteUtilisateur(id);

        return ResponseEntity.noContent().build();
    }
}