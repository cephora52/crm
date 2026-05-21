package com.example.crm.security;

import com.example.crm.entities.Utilisateurs;
import com.example.crm.repositories.UtilisateursRepo;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateursRepo utilisateursRepo;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Utilisateurs utilisateur = utilisateursRepo
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Utilisateur introuvable"));

        return new User(
                utilisateur.getEmail(),
                utilisateur.getMotDePasse(),
                Collections.emptyList()
        );
    }
}