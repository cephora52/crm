package com.example.crm.services.interfaces;

import com.example.crm.dtos.CampagnesDto;
import java.util.List;
import java.util.Optional;

public interface CampagnesInterface {

    List<CampagnesDto> getAllCampagnes();

    Optional<CampagnesDto> getCampagneById(Long id);

    CampagnesDto createCampagne(CampagnesDto campagnesDto);

    CampagnesDto updateCampagne(Long id, CampagnesDto campagnesDto);

    void deleteCampagne(Long id);

}