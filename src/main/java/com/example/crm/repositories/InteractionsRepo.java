package com.example.crm.repositories;

import com.example.crm.entities.Interactions;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractionsRepo extends JpaRepository<Interactions, Long> {

    List<Interactions> findByMessageContaining(String message);

}