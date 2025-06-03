package fr.cnam.pronosport.pronosport.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Table(name = "Sport")
@Entity
public class Sport {


    public Sport() {
    }
    
    public Sport(String nom) {
        this.nom = nom;
    }

    // c'est ce  constructeur qui sera utilisé pour créer l'objet à persister dans la base de donnée à partir des données reçu de l'api
    public Sport(int id_sport, String nom) {
        this.id_sport = id_sport;
        this.nom = nom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sport;

    @Column(name = "nom",nullable = false,length = 50 ,unique = true)
    private String nom;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_sport")
    private List<Competition> competitions;
    
    public int getId_sport() {
        return id_sport;
    }

    public void setId_sport(int id_sport) {
        this.id_sport = id_sport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Sport{" + "id_sport=" + id_sport + ", nom=" + nom + '}';
    }

}