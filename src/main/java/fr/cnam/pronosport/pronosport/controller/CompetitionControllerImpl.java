package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.model.Competition;
import fr.cnam.pronosport.pronosport.service.CompetitionService;

import java.util.List;

public class CompetitionControllerImpl implements CompetitionController {

    //Le contrôleur (ici, CompetitionControllerImpl) reçoit les requêtes (par exemple, d’une servlet ou d’un endpoint REST).

    private  final CompetitionService competitionService ;

    public CompetitionControllerImpl(CompetitionService competitionService) {
        this.competitionService = competitionService;

    }

    @Override
    public Competition getCompetitionById(int id) throws Exception {

        return competitionService.getById(id);
    }

    @Override
    public List<Competition> getAllCompetitions() throws Exception {

        return  competitionService.getAll();
    }

    @Override
    public void addCompetition(Competition competition) throws Exception {
        competitionService.add(competition);
    }


}
