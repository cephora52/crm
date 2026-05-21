package com.example.crm.mappers;

import com.example.crm.entities.Utilisateurs;
import com.mycompany.crm.dtos.UtilisateursDto;


public interface UtilisateursMapper {

    static UtilisateursDto toDto(Utilisateurs utilisateur) {

        if (utilisateur == null) {
            return null;
        }

        UtilisateursDto dto = new UtilisateursDto();

        dto.setId(utilisateur.getId());
        dto.setNom(utilisateur.getNom());
        dto.setEmail(utilisateur.getEmail());
        dto.setMotDePasse(utilisateur.getMotDePasse());
        dto.setRole(utilisateur.getRole());

        return dto;
    }

    static Utilisateurs toEntity(UtilisateursDto dto) {

        if (dto == null) {
            return null;
        }

        Utilisateurs utilisateur = new Utilisateurs();

        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMotDePasse(dto.getMotDePasse());
        utilisateur.setRole(dto.getRole());

        return utilisateur;
    }
}