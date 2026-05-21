package com.example.crm.mappers;

import com.example.crm.dtos.InteractionsDto;
import com.example.crm.entities.Campagnes;
import com.example.crm.entities.Clients;
import com.example.crm.entities.Interactions;
import com.example.crm.entities.Utilisateurs;

public interface InteractionsMapper {

    static InteractionsDto toDto(Interactions interaction) {

        if (interaction == null) {
            return null;
        }

        InteractionsDto dto = new InteractionsDto();

        dto.setId(interaction.getId());
        dto.setMessage(interaction.getMessage());

        dto.setDateInteraction(
                interaction.getDateInteraction() != null
                        ? interaction.getDateInteraction().toString()
                        : null
        );

        dto.setUtilisateurId(
                interaction.getUtilisateurId() != null
                        ? interaction.getUtilisateurId().getId()
                        : null
        );

        dto.setClientId(
                interaction.getClientId() != null
                        ? interaction.getClientId().getId()
                        : null
        );

        dto.setCampagneId(
                interaction.getCampagneId() != null
                        ? interaction.getCampagneId().getId()
                        : null
        );

        return dto;
    }

    static Interactions toEntity(InteractionsDto dto) {

        if (dto == null) {
            return null;
        }

        Interactions interaction = new Interactions();

        interaction.setId(dto.getId());
        interaction.setMessage(dto.getMessage());

        if (dto.getUtilisateurId() != null) {
            Utilisateurs utilisateur = new Utilisateurs();
            utilisateur.setId(dto.getUtilisateurId());
            interaction.setUtilisateurId(utilisateur);
        }

        if (dto.getClientId() != null) {
            Clients client = new Clients();
            client.setId(dto.getClientId());
            interaction.setClientId(client);
        }

        if (dto.getCampagneId() != null) {
            Campagnes campagne = new Campagnes();
            campagne.setId(dto.getCampagneId());
            interaction.setCampagneId(campagne);
        }

        return interaction;
    }
}