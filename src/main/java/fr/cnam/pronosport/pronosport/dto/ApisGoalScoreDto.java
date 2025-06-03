package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class ApisGoalScoreDto {
    
    @SerializedName("away")
    private int away;
    
    @SerializedName("home")
    private int home;


    public int getAway() {
        return away;
    }

    public void setAway(int away) {
        this.away = away;
    }

    public int getHome() {
        return home;
    }


    public void setHome(int home) {
        this.home = home;
    }

    
}
