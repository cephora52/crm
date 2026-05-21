package com.example.crm.mappers;

import com.example.crm.dtos.ClientsDto;
import com.example.crm.entities.Clients;


public interface ClientsMapper {

    static ClientsDto toDto(Clients client) {

        if (client == null) {
            return null;
        }

        ClientsDto dto = new ClientsDto();

        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setTelephone(client.getTelephone());
        dto.setEmail(client.getEmail());
        dto.setAdresse(client.getAdresse());

        return dto;
    }

    static Clients toEntity(ClientsDto dto) {

        if (dto == null) {
            return null;
        }

        Clients client = new Clients();

        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setTelephone(dto.getTelephone());
        client.setEmail(dto.getEmail());
        client.setAdresse(dto.getAdresse());

        return client;
    }
}