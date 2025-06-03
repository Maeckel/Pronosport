package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class ApiScoreFullTimeDto {

    @SerializedName("home")
    private int home;
    
    @SerializedName("away")
    private int away;

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getAway() {
        return away;
    }

    public void setAway(int away) {
        this.away = away;
    }


    }

    

