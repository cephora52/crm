package com.example.crm.repositories;

import com.example.crm.entities.Clients;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepo extends JpaRepository<Clients, Long> {

    List<Clients> findByNom(String nom);

    List<Clients> findByEmail(String email);

}