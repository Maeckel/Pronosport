package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class GoalDto {

    @SerializedName("minute")
    private int minute;

    @SerializedName("score")
    private ApisGoalScoreDto score;

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public ApisGoalScoreDto getScore() {
        return score;
    }

    public void setScore(ApisGoalScoreDto score) {
        this.score = score;
    }
    
}
