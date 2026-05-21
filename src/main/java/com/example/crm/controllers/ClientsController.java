package com.example.crm.controllers;

import com.example.crm.dtos.ClientsDto;
import com.example.crm.services.interfaces.ClientsInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientsController {

    @Autowired
    private ClientsInterface clientsInterface;

    @GetMapping
    public List<ClientsDto> getAllClients() {

        return clientsInterface.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientsDto> getClientById(@PathVariable Long id) {

        Optional<ClientsDto> client = clientsInterface.getClientById(id);

        return client.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientsDto> createClient(
            @RequestBody ClientsDto clientsDto) {

        return ResponseEntity.ok(
                clientsInterface.createClient(clientsDto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientsDto> updateClient(
            @PathVariable Long id,
            @RequestBody ClientsDto clientsDto) {

        return ResponseEntity.ok(
                clientsInterface.updateClient(id, clientsDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {

        clientsInterface.deleteClient(id);

        return ResponseEntity.noContent().build();
    }
}