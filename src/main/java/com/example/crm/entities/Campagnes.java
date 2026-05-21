package com.example.crm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "campagnes")
@NamedQueries({
        @NamedQuery(name = "Campagnes.findAll", query = "SELECT c FROM Campagnes c"),
        @NamedQuery(name = "Campagnes.findById", query = "SELECT c FROM Campagnes c WHERE c.id = :id"),
        @NamedQuery(name = "Campagnes.findByTitre", query = "SELECT c FROM Campagnes c WHERE c.titre = :titre"),
        @NamedQuery(name = "Campagnes.findByDateDebut", query = "SELECT c FROM Campagnes c WHERE c.dateDebut = :dateDebut"),
        @NamedQuery(name = "Campagnes.findByDateFin", query = "SELECT c FROM Campagnes c WHERE c.dateFin = :dateFin")})
public class Campagnes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "titre")
    private String titre;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campagneId")
    private Collection<Interactions> interactionsCollection;

    public Campagnes() {
    }

    public Campagnes(Long id) {
        this.id = id;
    }

    public Campagnes(Long id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
        if (!(object instanceof Campagnes)) {
            return false;
        }
        Campagnes other = (Campagnes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crm.Campagnes[ id=" + id + " ]";
    }

}
