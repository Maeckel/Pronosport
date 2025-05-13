package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.model.entity.Competition;

import java.util.List;

public interface CompetitionController {
    Competition getCompetitionById(int id) throws Exception;
    List<Competition>  getAllCompetitions() throws Exception;
    void addCompetition(Competition competition) throws Exception;
}
