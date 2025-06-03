package fr.cnam.pronosport.pronosport.dto;

public class GoalDto {
    private int minute;
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
