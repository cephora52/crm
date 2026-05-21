package com.example.crm.services.implementations;

import com.example.crm.dtos.ClientsDto;
import com.example.crm.entities.Clients;
import com.example.crm.mappers.ClientsMapper;
import com.example.crm.repositories.ClientsRepo;
import com.example.crm.services.interfaces.ClientsInterface;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService implements ClientsInterface {

    @Autowired
    private ClientsRepo clientsRepo;

    @Override
    public List<ClientsDto> getAllClients() {

        return clientsRepo.findAll()
                .stream()
                .map(ClientsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientsDto> getClientById(Long id) {

        return clientsRepo.findById(id)
                .map(ClientsMapper::toDto);
    }

    @Override
    public ClientsDto createClient(ClientsDto clientsDto) {

        Clients client = ClientsMapper.toEntity(clientsDto);

        Clients savedClient = clientsRepo.save(client);

        return ClientsMapper.toDto(savedClient);
    }

    @Override
    public ClientsDto updateClient(Long id, ClientsDto clientsDto) {

        Clients client = clientsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        client.setNom(clientsDto.getNom());
        client.setTelephone(clientsDto.getTelephone());
        client.setEmail(clientsDto.getEmail());
        client.setAdresse(clientsDto.getAdresse());

        Clients updatedClient = clientsRepo.save(client);

        return ClientsMapper.toDto(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {

        clientsRepo.deleteById(id);
    }
}