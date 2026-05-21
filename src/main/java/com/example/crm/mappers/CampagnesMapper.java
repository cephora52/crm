package com.example.crm.mappers;

import com.example.crm.dtos.CampagnesDto;
import com.example.crm.entities.Campagnes;

public interface CampagnesMapper {

    static CampagnesDto toDto(Campagnes campagne) {

        if (campagne == null) {
            return null;
        }

        CampagnesDto dto = new CampagnesDto();

        dto.setId(campagne.getId());
        dto.setTitre(campagne.getTitre());
        dto.setDescription(campagne.getDescription());

        dto.setDateDebut(
                campagne.getDateDebut() != null
                        ? campagne.getDateDebut().toString()
                        : null
        );

        dto.setDateFin(
                campagne.getDateFin() != null
                        ? campagne.getDateFin().toString()
                        : null
        );

        return dto;
    }

    static Campagnes toEntity(CampagnesDto dto) {

        if (dto == null) {
            return null;
        }

        Campagnes campagne = new Campagnes();

        campagne.setId(dto.getId());
        campagne.setTitre(dto.getTitre());
        campagne.setDescription(dto.getDescription());

        return campagne;
    }
}