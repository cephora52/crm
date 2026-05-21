package com.example.crm.services.interfaces;

import com.example.crm.dtos.ClientsDto;
import java.util.List;
import java.util.Optional;

public interface ClientsInterface {

    List<ClientsDto> getAllClients();

    Optional<ClientsDto> getClientById(Long id);

    ClientsDto createClient(ClientsDto clientsDto);

    ClientsDto updateClient(Long id, ClientsDto clientsDto);

    void deleteClient(Long id);

}