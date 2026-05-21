package com.example.crm.repositories;

import com.example.crm.entities.Utilisateurs;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateursRepo extends JpaRepository<Utilisateurs, Long> {

    Optional<Utilisateurs> findByEmail(String email);

}