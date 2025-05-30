package fr.cnam.pronosport.pronosport.model;


import jakarta.persistence.*;

import java.util.Date;

@Table(name = "Matche")
@Entity
public class Match {


    public Match() {
    }

    public Match( int minute, String status, String score, Date date_heure, String pronostic) {
        this.id = id;
        this.minute = minute;
        this.status = status;
        this.score = score;
        this.date_heure = date_heure;
        this.pronostic = pronostic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "minute",nullable = false,length = 50 )
    private int minute;


    @Column(name = "status",nullable = false,length = 50 )
    private String status;


    @Column(name = "score",nullable = false,length = 50 )
    private String score;


    @Temporal(TemporalType.DATE)
    @Column(name = "date_heure",nullable = false,length = 50 )
    private Date date_heure;


    @Column(name = "pronostic",nullable = false,length = 50 )
    private String pronostic;


    @Column(name = "compositionEquipeA",nullable = false,length = 50 )
    private String compositionEquipeA;



    @Column(name = "compositionEquipeB",nullable = false,length = 50 )
    private String compositionEquipeB;

    // Table Match
    @ManyToOne
    @JoinColumn(name = "competition_id") // clé étrangère dans la table Match
    private Competition competition;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getDate_heure() {
        return date_heure;
    }

    public void setDate_heure(Date date_heure) {
        this.date_heure = date_heure;
    }

    public String getPronostic() {
        return pronostic;
    }

    public void setPronostic(String pronostic) {
        this.pronostic = pronostic;
    }

    public String getCompositionEquipeA() {
        return compositionEquipeA;
    }

    public void setCompositionEquipeA(String compositionEquipeA) {
        this.compositionEquipeA = compositionEquipeA;
    }

    public String getCompositionEquipeB() {
        return compositionEquipeB;
    }

    public void setCompositionEquipeB(String compositionEquipeB) {
        this.compositionEquipeB = compositionEquipeB;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}