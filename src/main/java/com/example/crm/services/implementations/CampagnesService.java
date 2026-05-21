package com.example.crm.services.implementations;

import com.example.crm.dtos.CampagnesDto;
import com.example.crm.entities.Campagnes;
import com.example.crm.mappers.CampagnesMapper;
import com.example.crm.repositories.CampagnesRepo;
import com.example.crm.services.interfaces.CampagnesInterface;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampagnesService implements CampagnesInterface {

    @Autowired
    private CampagnesRepo campagnesRepo;

    @Override
    public List<CampagnesDto> getAllCampagnes() {

        return campagnesRepo.findAll()
                .stream()
                .map(CampagnesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CampagnesDto> getCampagneById(Long id) {

        return campagnesRepo.findById(id)
                .map(CampagnesMapper::toDto);
    }

    @Override
    public CampagnesDto createCampagne(CampagnesDto campagnesDto) {

        Campagnes campagne = CampagnesMapper.toEntity(campagnesDto);

        Campagnes savedCampagne = campagnesRepo.save(campagne);

        return CampagnesMapper.toDto(savedCampagne);
    }

    @Override
    public CampagnesDto updateCampagne(Long id, CampagnesDto campagnesDto) {

        Campagnes campagne = campagnesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Campagne introuvable"));

        campagne.setTitre(campagnesDto.getTitre());
        campagne.setDescription(campagnesDto.getDescription());

        Campagnes updatedCampagne = campagnesRepo.save(campagne);

        return CampagnesMapper.toDto(updatedCampagne);
    }

    @Override
    public void deleteCampagne(Long id) {

        campagnesRepo.deleteById(id);
    }
}