package com.example.crm.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "interactions")
@NamedQueries({
        @NamedQuery(name = "Interactions.findAll", query = "SELECT i FROM Interactions i"),
        @NamedQuery(name = "Interactions.findById", query = "SELECT i FROM Interactions i WHERE i.id = :id"),
        @NamedQuery(name = "Interactions.findByDateInteraction", query = "SELECT i FROM Interactions i WHERE i.dateInteraction = :dateInteraction")})
public class Interactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(name = "message")
    private String message;
    @Column(name = "date_interaction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInteraction;
    @JoinColumn(name = "campagne_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Campagnes campagneId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clients clientId;
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilisateurs utilisateurId;

    public Interactions() {
    }

    public Interactions(Long id) {
        this.id = id;
    }

    public Interactions(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateInteraction() {
        return dateInteraction;
    }

    public void setDateInteraction(Date dateInteraction) {
        this.dateInteraction = dateInteraction;
    }

    public Campagnes getCampagneId() {
        return campagneId;
    }

    public void setCampagneId(Campagnes campagneId) {
        this.campagneId = campagneId;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Utilisateurs getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Utilisateurs utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interactions)) {
            return false;
        }
        Interactions other = (Interactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crm.Interactions[ id=" + id + " ]";
    }

}
