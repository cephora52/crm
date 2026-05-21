package com.mycompany.crm.controllers;

import com.example.crm.dtos.CampagnesDto;
import com.example.crm.services.interfaces.CampagnesInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/campagnes")
@CrossOrigin("*")
public class CampagnesController {

    @Autowired
    private CampagnesInterface campagnesInterface;

    @GetMapping
    public List<CampagnesDto> getAllCampagnes() {

        return campagnesInterface.getAllCampagnes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampagnesDto> getCampagneById(@PathVariable Long id) {

        Optional<CampagnesDto> campagne = campagnesInterface.getCampagneById(id);

        return campagne.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CampagnesDto> createCampagne(
            @RequestBody CampagnesDto campagnesDto) {

        return ResponseEntity.ok(
                campagnesInterface.createCampagne(campagnesDto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampagnesDto> updateCampagne(
            @PathVariable Long id,
            @RequestBody CampagnesDto campagnesDto) {

        return ResponseEntity.ok(
                campagnesInterface.updateCampagne(id, campagnesDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampagne(@PathVariable Long id) {

        campagnesInterface.deleteCampagne(id);

        return ResponseEntity.noContent().build();
    }
}