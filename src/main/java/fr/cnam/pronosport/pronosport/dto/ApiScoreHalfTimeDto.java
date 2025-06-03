package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class ApiScoreHalfTimeDto {

    @SerializedName("home")
    private String home;
    
    @SerializedName("away")
    private String away;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    }

    

