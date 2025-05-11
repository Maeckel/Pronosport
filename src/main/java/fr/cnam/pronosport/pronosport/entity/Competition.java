package fr.cnam.pronosport.pronosport.entity;


    /**
     * Exemple:
     * https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
     */
import jakarta.persistence.*;


@Entity
public class Competition {


    public Competition() {
    }

    public Competition(int id, String nom, String type, String zone) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.zone = zone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "nom",nullable = false,length = 50)
    private String nom;

    @Column(name = "type",nullable = false,length = 50)
    private String type;

    @Column(name="zone",nullable = false,length = 50)
    private String zone;


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