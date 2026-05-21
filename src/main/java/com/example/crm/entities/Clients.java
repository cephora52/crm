package com.example.crm.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "clients")
@NamedQueries({
        @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
        @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
        @NamedQuery(name = "Clients.findByNom", query = "SELECT c FROM Clients c WHERE c.nom = :nom"),
        @NamedQuery(name = "Clients.findByTelephone", query = "SELECT c FROM Clients c WHERE c.telephone = :telephone"),
        @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
        @NamedQuery(name = "Clients.findByAdresse", query = "SELECT c FROM Clients c WHERE c.adresse = :adresse")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "adresse")
    private String adresse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<Interactions> interactionsCollection;

    public Clients() {
    }

    public Clients(Long id) {
        this.id = id;
    }

    public Clients(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Interactions> getInteractionsCollection() {
        return interactionsCollection;
    }

    public void setInteractionsCollection(Collection<Interactions> interactionsCollection) {
        this.interactionsCollection = interactionsCollection;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crm.Clients[ id=" + id + " ]";
    }

}
