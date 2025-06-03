package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.model.Match;
import fr.cnam.pronosport.pronosport.service.MatchService;
import java.util.List;

public class MatchControllerImpl implements MatchController {

    //Le contrôleur (ici, MatchControllerImpl) reçoit les requêtes (par exemple, d’une servlet ou d’un endpoint REST).

    private  final MatchService matchService ;

    public MatchControllerImpl(MatchService matchService) {
        this.matchService = matchService;

    }

    @Override
    public Match getMatchById(int id) throws Exception {

        return matchService.getById(id);
    }

    @Override
    public List<Match> getAllMatchs() throws Exception {

        return  matchService.getAll();
    }

    @Override
    public void addMatch(Match match) throws Exception {
        matchService.add(match);
    }
    
    @Override
    public List<Match> getMatchesForCompetitions(List<Integer> competitionIds) {
        
        return matchService.getMatchesForCompetitions(competitionIds);
        
    }

    


}
