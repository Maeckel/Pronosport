package fr.cnam.pronosport.pronosport.repository;

import fr.cnam.pronosport.pronosport.model.Competition;
import fr.cnam.pronosport.pronosport.model.Match;

import java.util.List;

/*
Ici on définit les signatures des fonctions qui vont être implémentées dans les classes qui implémenteront cette interface
permet d'avoir des noms définit
*/

public interface CompetitionRepository {

    Competition getCompetitionById(int id) throws Exception ;

    List<Competition> getAllCompetitions() throws Exception ;

    void addCompetition(Competition competition) throws Exception;




}
