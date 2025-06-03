package fr.cnam.pronosport.pronosport.controller;

import java.util.List;
import fr.cnam.pronosport.pronosport.model.Competition;
import fr.cnam.pronosport.pronosport.model.Match;
import java.util.List;

public interface MatchController {
    Match getMatchById(int id) throws Exception;
    List<Match>  getAllMatchs() throws Exception;
    List<Match> getMatchesForCompetitions(List<Integer> competitionIds);
    void addMatch(Match match) throws Exception;
}

