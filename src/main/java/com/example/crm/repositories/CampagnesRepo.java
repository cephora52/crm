package com.example.crm.repositories;

import com.example.crm.entities.Campagnes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagnesRepo extends JpaRepository<Campagnes, Long> {

    List<Campagnes> findByTitre(String titre);

}