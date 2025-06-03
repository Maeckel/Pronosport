package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class ApiMatchDto {
    @SerializedName("lastUpdated")
    private String lastUpdated;
    
    @SerializedName("score")
    private ApiScoreDto score;
    
    @SerializedName("minute")
    private String minute;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("pronostic")
    private ApiScoreDto pronostic;
    
    @SerializedName("homeTeam")
    private ApiHomeTeamDto homeTeam;
    
    @SerializedName("awayTeam")
    private ApiAwayTeamDto awayTeam;

    @SerializedName("competition")
    ApiMatchCompetitionDto competition;

    @SerializedName("goals")
    ApiMatchCompetitionDto goals ;

    public ApiMatchCompetitionDto getCompetition() {
        return competition;
    }

    public void setCompetition(ApiMatchCompetitionDto competition) {
        this.competition = competition;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ApiScoreDto getScore() {
        return score;
    }

    public void setScore(ApiScoreDto score) {
        this.score = score;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ApiScoreDto getPronostic() {
        return pronostic;
    }

    public void setPronostic(ApiScoreDto pronostic) {
        this.pronostic = pronostic;
    }

    public ApiHomeTeamDto getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(ApiHomeTeamDto homeTeam) {
        this.homeTeam = homeTeam;
    }

    public ApiAwayTeamDto getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(ApiAwayTeamDto awayTeam) {
        this.awayTeam = awayTeam;
    }
    
}

