package fr.cnam.pronosport.pronosport.repository;

import fr.cnam.pronosport.pronosport.model.Match;

import java.util.List;

/*
Ici on définit les signatures des fonctions qui vont être implémentées dans les classes qui implémenteront cette interface
permet d'avoir des noms définit
*/

public interface MatchRepository {
    Match getMatchById(int id) throws Exception ;
    List<Match> getAllMatchs() throws Exception ;
    void addMatch(Match match) throws Exception;

    List<Match> getMatchesForCompetitions(List<Integer> competitionIds);
}
