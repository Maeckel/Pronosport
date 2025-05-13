package fr.cnam.pronosport.pronosport.service;

import fr.cnam.pronosport.pronosport.dto.ApiCompetitionDto;
import fr.cnam.pronosport.pronosport.model.entity.Competition;
import fr.cnam.pronosport.pronosport.repository.CompetitionRepository;

import java.util.List;


/*
    Contrôleur  --->  Service  --->  Repository  --->  Base de données

    Le contrôleur reçoit la requête (par exemple, d’une servlet, d’un endpoint REST ou d’une interface graphique).

    Le service fait tout le travail métier (appels repository, transformation, logique métier).

    Le repository ne sert qu’à accéder à la base de données.
*/

public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final ApiClient apiClient;


    public CompetitionServiceImpl(CompetitionRepository competitionRepository, ApiClient apiClient) {
        this.competitionRepository = competitionRepository;
        this.apiClient = apiClient;
    }




        public void importCompetitionsFromApi() throws Exception {
            // 1. Appel à l’API externe
            List<ApiCompetitionDto> apiCompetitions = List.of(apiClient.getAllCompetitions());

            // 2. Transformation et persistence
            for (ApiCompetitionDto apiComp : apiCompetitions) {
                //Pour chaque compétition récupéré on instancie un objet de type Competition à persisiter dans la base
                Competition competition = new Competition();

                competition.setNom(apiComp.getName());
                competition.setType(apiComp.getType());
                competition.setZone(apiComp.getArea().getName());

                // 3. Persistance dans la base de données
                this. add(competition);

            }
        }


    @Override
    public Competition getById(int id) throws Exception {

        return competitionRepository.getCompetitionById(id);
    }


    @Override
    public List<Competition> getAll() throws Exception {
        return competitionRepository.getAllCompetitions();
    }


    @Override
    public void add(Competition competition) throws Exception {
        competitionRepository.addCompetition(competition);
    }


}
