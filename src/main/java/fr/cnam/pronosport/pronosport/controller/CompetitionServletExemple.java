package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.repository.CompetitionRepository;
import fr.cnam.pronosport.pronosport.repository.CompetitionRepositoryImpl;
import fr.cnam.pronosport.pronosport.service.ApiClient;
import fr.cnam.pronosport.pronosport.service.ApiClientImpl;
import fr.cnam.pronosport.pronosport.service.CompetitionService;
import fr.cnam.pronosport.pronosport.service.CompetitionServiceImpl;

public class CompetitionServletExemple {

    // exemple de requête
    // Demande d'affichage de la liste des competitions



    /*
    Cheminement: Contrôleur  --->  Service  --->  Repository  --->  Base de données

    Le contrôleur reçoit la requête (par exemple, d’une servlet, d’un endpoint REST ou d’une interface graphique).

    Le service fait tout le travail métier (appels repository, transformation, logique métier).

    Le repository ne sert qu’à accéder à la base de données.

*/

    //Injection de dépendance

}
