package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.model.Match;
import fr.cnam.pronosport.pronosport.service.CompetitionService;

import java.util.List;

public class MatchControllerImpl implements MatchController {
    @Override
    public Match getMatchById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Match> getMatchesForCompetitions(List<Long> competitionIds) throws Exception {
        return null;
    }

    /*Cheminement: Contrôleur  --->  Service  --->  Repository  --->  Base de données

    Le contrôleur reçoit la requête (par exemple, d’une servlet, d’un endpoint REST ou d’une interface graphique).

    Le service fait tout le travail métier (appels repository, transformation, logique métier).

    Le repository ne sert qu’à accéder à la base de données.

    //les différentes méthode qui vont appeler MatchService
    //private  final MatchService competitionService ;

    //1.créer une interface pour Match dans le package fr.cnam.pronosport.pronosport.controller
    //2.créer une classe MatchControllerImpl dans   le package fr.cnam.pronosport.pronosport.controller voir exemple CompetitionControllerImpl
    //3.créer une Interface MatchService  dans le package fr.cnam.pronosport.pronosport.service et voir exemple CompetitionService
    //4.créer une classe MatchServiceImpl dans le package fr.cnam.pronosport.pronosport.service
    //5.créer  les signatures  des methodes pour match dans ApiClient
    //6.implémenter les méthodes de match dans ApiClientImpl

*/




}
