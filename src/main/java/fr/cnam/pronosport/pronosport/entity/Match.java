package fr.cnam.pronosport.pronosport.entity;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class Match {


    public Match() {
    }


    private int id;

    /**
     * 
     */
    private int minute;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String score;


    @Temporal(TemporalType.DATE)
    private Date date_heure;


    private String pronostic;


    private void compositionEquipeA(){

    };

    /**
     * 
     */
    private void compositionEquipeB(){


    };



}