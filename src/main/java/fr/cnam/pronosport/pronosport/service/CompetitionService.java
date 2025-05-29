package fr.cnam.pronosport.pronosport.service;

import fr.cnam.pronosport.pronosport.model.Competition;

import java.util.List;

public interface CompetitionService {
    void importCompetitionsFromApi() throws Exception;

    Competition getById(int id) throws Exception;

    List<Competition> getAll() throws Exception;

    void add(Competition competition) throws Exception;

}
