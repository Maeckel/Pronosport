package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;


public class ApiSportDto {


    @SerializedName("nom")
    private String nom;

    public String getNom() {
        return nom;
    }

}
