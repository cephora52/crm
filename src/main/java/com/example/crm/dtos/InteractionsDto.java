package com.example.crm.dtos;

import java.io.Serializable;

public class InteractionsDto implements Serializable {

    private Long id;
    private String message;
    private String dateInteraction;

    private Long utilisateurId;
    private Long clientId;
    private Long campagneId;

    public InteractionsDto() {
    }

    public InteractionsDto(Long id, String message, String dateInteraction,
                           Long utilisateurId, Long clientId, Long campagneId) {
        this.id = id;
        this.message = message;
        this.dateInteraction = dateInteraction;
        this.utilisateurId = utilisateurId;
        this.clientId = clientId;
        this.campagneId = campagneId;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getDateInteraction() {
        return dateInteraction;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getCampagneId() {
        return campagneId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateInteraction(String dateInteraction) {
        this.dateInteraction = dateInteraction;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setCampagneId(Long campagneId) {
        this.campagneId = campagneId;
    }
}