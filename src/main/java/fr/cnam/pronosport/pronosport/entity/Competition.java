package fr.cnam.pronosport.pronosport.entity;


    /**
     * Exemple:
     * https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
     */
import jakarta.persistence.*;

//@Entity(name = "Competition")
@Entity
public class Competition {


    public Competition() {
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

}