package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class ApiScoreDto {
    
    @SerializedName("away")
    private int away;
    
    @SerializedName("home")
    private int home;
       
    @SerializedName("halfTime")
    private ApiScoreHalfTimeDto halfTime;
    
    @SerializedName("fullTime")
    private ApiScoreFullTimeDto fullTime;



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

    public ApiScoreHalfTimeDto getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(ApiScoreHalfTimeDto halfTime) {
        this.halfTime = halfTime;
    }

    public ApiScoreFullTimeDto getFullTime() {
        return fullTime;
    }

    public void setFullTime(ApiScoreFullTimeDto fullTime) {
        this.fullTime = fullTime;
    }
    
}
