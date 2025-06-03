package fr.cnam.pronosport.pronosport.service;

import fr.cnam.pronosport.pronosport.model.Match;

import java.util.List;

public interface MatchService {
    void importMatchsFromApi() throws Exception;

    Match getById(int id) throws Exception;

    List<Match> getAll() throws Exception;

    void add(Match match) throws Exception;

    public List<Match> getMatchesForCompetitions(List<Integer> competitionIds);
    
}
