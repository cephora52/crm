package com.example.crm.controllers;

import com.example.crm.dtos.InteractionsDto;
import com.example.crm.services.interfaces.InteractionsInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interactions")
@CrossOrigin("*")
public class InteractionsController {

    @Autowired
    private InteractionsInterface interactionsInterface;

    @GetMapping
    public List<InteractionsDto> getAllInteractions() {

        return interactionsInterface.getAllInteractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteractionsDto> getInteractionById(@PathVariable Long id) {

        Optional<InteractionsDto> interaction = interactionsInterface.getInteractionById(id);

        return interaction.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InteractionsDto> createInteraction(
            @RequestBody InteractionsDto interactionsDto) {

        return ResponseEntity.ok(
                interactionsInterface.createInteraction(interactionsDto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<InteractionsDto> updateInteraction(
            @PathVariable Long id,
            @RequestBody InteractionsDto interactionsDto) {

        return ResponseEntity.ok(
                interactionsInterface.updateInteraction(id, interactionsDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {

        interactionsInterface.deleteInteraction(id);

        return ResponseEntity.noContent().build();
    }
}