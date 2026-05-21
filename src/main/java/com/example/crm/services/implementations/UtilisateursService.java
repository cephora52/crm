package com.example.crm.services.implementations;

import com.example.crm.entities.Utilisateurs;
import com.example.crm.mappers.UtilisateursMapper;
import com.example.crm.repositories.UtilisateursRepo;
import com.example.crm.services.interfaces.UtilisateursInterface;
import com.mycompany.crm.dtos.UtilisateursDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateursService implements UtilisateursInterface {

    @Autowired
    private UtilisateursRepo utilisateursRepo;

    @Override
    public List<UtilisateursDto> getAllUtilisateurs() {

        return utilisateursRepo.findAll()
                .stream()
                .map(UtilisateursMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UtilisateursDto> getUtilisateurById(Long id) {

        return utilisateursRepo.findById(id)
                .map(UtilisateursMapper::toDto);
    }

    @Override
    public UtilisateursDto createUtilisateur(UtilisateursDto utilisateursDto) {

        Utilisateurs utilisateur = UtilisateursMapper.toEntity(utilisateursDto);

        Utilisateurs savedUtilisateur = utilisateursRepo.save(utilisateur);

        return UtilisateursMapper.toDto(savedUtilisateur);
    }

    @Override
    public UtilisateursDto updateUtilisateur(Long id, UtilisateursDto utilisateursDto) {

        Utilisateurs utilisateur = utilisateursRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        utilisateur.setNom(utilisateursDto.getNom());
        utilisateur.setEmail(utilisateursDto.getEmail());
        utilisateur.setMotDePasse(utilisateursDto.getMotDePasse());
        utilisateur.setRole(utilisateursDto.getRole());

        Utilisateurs updatedUtilisateur = utilisateursRepo.save(utilisateur);

        return UtilisateursMapper.toDto(updatedUtilisateur);
    }

    @Override
    public void deleteUtilisateur(Long id) {

        utilisateursRepo.deleteById(id);
    }
}