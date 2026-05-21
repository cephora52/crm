package com.example.crm.services.interfaces;

import com.mycompany.crm.dtos.UtilisateursDto;
import java.util.List;
import java.util.Optional;

public interface UtilisateursInterface {

    List<UtilisateursDto> getAllUtilisateurs();

    Optional<UtilisateursDto> getUtilisateurById(Long id);

    UtilisateursDto createUtilisateur(UtilisateursDto utilisateursDto);

    UtilisateursDto updateUtilisateur(Long id, UtilisateursDto utilisateursDto);

    void deleteUtilisateur(Long id);

}