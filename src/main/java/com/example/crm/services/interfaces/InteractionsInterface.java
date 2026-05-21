package com.example.crm.services.interfaces;

import com.example.crm.dtos.InteractionsDto;
import java.util.List;
import java.util.Optional;

public interface InteractionsInterface {

    List<InteractionsDto> getAllInteractions();

    Optional<InteractionsDto> getInteractionById(Long id);

    InteractionsDto createInteraction(InteractionsDto interactionsDto);

    InteractionsDto updateInteraction(Long id, InteractionsDto interactionsDto);

    void deleteInteraction(Long id);

}