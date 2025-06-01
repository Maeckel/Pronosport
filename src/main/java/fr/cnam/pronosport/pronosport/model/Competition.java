package fr.cnam.pronosport.pronosport.model;


    /**
     * Exemple:
     *
     */
import jakarta.persistence.*;

import java.util.List;

@Table(name = "Competition")
@Entity
public class Competition {


    public Competition() {
    }

    // c'est ce  constructeur qui sera utilisé pour créer l'objet à persister dans la base de donnée à partir des données reçu de l'api
    public Competition(String nom, String type, String zone) {
        this.nom = nom;
        this.type = type;
        this.zone = zone;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "nom",nullable = false,length = 50 ,unique = true)
    private String nom;

    @Column(name = "type",nullable = false,length = 50 ,unique = true)
    private String type;

    @Column(name="zone",nullable = false,length = 50,unique = true)
    private String zone;
    // Ici une compétition peux avoir 1 ou plusieurs match
// Relation OneToMany avec Match

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "competition_id")
    private List<Match> matches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}