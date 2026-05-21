package com.example.crm.services.implementations;

import com.example.crm.dtos.InteractionsDto;
import com.example.crm.entities.Campagnes;
import com.example.crm.entities.Clients;
import com.example.crm.entities.Interactions;
import com.example.crm.entities.Utilisateurs;
import com.example.crm.mappers.InteractionsMapper;
import com.example.crm.repositories.CampagnesRepo;
import com.example.crm.repositories.ClientsRepo;
import com.example.crm.repositories.InteractionsRepo;
import com.example.crm.repositories.UtilisateursRepo;
import com.example.crm.services.interfaces.InteractionsInterface;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionsService implements InteractionsInterface {

    @Autowired
    private InteractionsRepo interactionsRepo;

    @Autowired
    private UtilisateursRepo utilisateursRepo;

    @Autowired
    private ClientsRepo clientsRepo;

    @Autowired
    private CampagnesRepo campagnesRepo;

    @Override
    public List<InteractionsDto> getAllInteractions() {

        return interactionsRepo.findAll()
                .stream()
                .map(InteractionsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InteractionsDto> getInteractionById(Long id) {

        return interactionsRepo.findById(id)
                .map(InteractionsMapper::toDto);
    }

    @Override
    public InteractionsDto createInteraction(InteractionsDto interactionsDto) {

        Utilisateurs utilisateur = utilisateursRepo.findById(interactionsDto.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        Clients client = clientsRepo.findById(interactionsDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        Campagnes campagne = campagnesRepo.findById(interactionsDto.getCampagneId())
                .orElseThrow(() -> new RuntimeException("Campagne introuvable"));

        Interactions interaction = new Interactions();

        interaction.setMessage(interactionsDto.getMessage());
        interaction.setUtilisateurId(utilisateur);
        interaction.setClientId(client);
        interaction.setCampagneId(campagne);

        Interactions savedInteraction = interactionsRepo.save(interaction);

        return InteractionsMapper.toDto(savedInteraction);
    }

    @Override
    public InteractionsDto updateInteraction(Long id, InteractionsDto interactionsDto) {

        Interactions interaction = interactionsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Interaction introuvable"));

        interaction.setMessage(interactionsDto.getMessage());

        Interactions updatedInteraction = interactionsRepo.save(interaction);

        return InteractionsMapper.toDto(updatedInteraction);
    }

    @Override
    public void deleteInteraction(Long id) {

        interactionsRepo.deleteById(id);
    }
}