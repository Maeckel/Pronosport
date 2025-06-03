package fr.cnam.pronosport.pronosport.service;

import fr.cnam.pronosport.pronosport.dto.ApiMatchDto;
import fr.cnam.pronosport.pronosport.dto.ApisGoalScoreDto;
import fr.cnam.pronosport.pronosport.model.Competition;
import fr.cnam.pronosport.pronosport.model.Match;
import fr.cnam.pronosport.pronosport.repository.CompetitionRepository;
import fr.cnam.pronosport.pronosport.repository.CompetitionRepositoryImpl;
import fr.cnam.pronosport.pronosport.repository.MatchRepository;

import java.util.List;


/*
    Contrôleur  --->  Service  --->  Repository  --->  Base de données

    Le contrôleur reçoit la requête (par exemple, d’une servlet, d’un endpoint REST ou d’une interface graphique).

    Le service fait tout le travail métier (appels repository, transformation, logique métier).

    Le repository ne sert qu’à accéder à la base de données.
 */
public class MatchServiceImpl implements MatchService {
// injection de dépendance

    private final MatchRepository matchRepository;
    private final ApiClient apiClient;

    public MatchServiceImpl(MatchRepository matchRepository, ApiClient apiClient) {
        this.matchRepository = matchRepository;
        this.apiClient = apiClient;
    }

    @Override
    public void importMatchsFromApi() throws Exception {
        // 1. Appel à l’API externe
        List<ApiMatchDto> apiMatchs = List.of(apiClient.getAllMatchs());
        CompetitionRepository competitionRepository = new CompetitionRepositoryImpl(); 
        // à injecter par le constructeur
        List<Competition> competitions = competitionRepository.getAllCompetitions();

        // Pour chaque match de l’API
        for (ApiMatchDto apiMatch : apiMatchs) {          
            Competition competition = competitions.stream()
                    .filter(c -> c.getNom().equals(apiMatch.getCompetition().getName())
                    && c.getType().equals(apiMatch.getCompetition().getType()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Compétition non trouvée"));

            // Créer l'objet  match
            Match match = new Match();

            // Pour chaque goal prendre le score away et  le score home
            ApisGoalScoreDto goalScoreDto = new ApisGoalScoreDto();
            match.setScore(goalScoreDto.getHome());
            match.setScore(goalScoreDto.getAway());
            match.setCompetition(competition); // Association. JPA/Hibernate s’occupe d’insérer la clé étrangère (competition_id) dans la table Match lors de la persistance.
            // setCompetition vient de la classe Match
            /*@ManyToOne
        @JoinColumn(name = "competition_id") // clé étrangère competition_id dans la table Match
        private Competition competition;*/
            matchRepository.addMatch(match);
        }

        // 2. Transformation et persistence
       
    }

    @Override
    public Match getById(int id) throws Exception {

        return matchRepository.getMatchById(id);
    }

    @Override
    public List<Match> getAll() throws Exception {
        return matchRepository.getAllMatchs();
    }

    @Override
    public void add(Match match) throws Exception {
        matchRepository.addMatch(match);
    }

    @Override
    public List<Match> getMatchesForCompetitions(List<Integer> competitionIds) {

        return matchRepository.getMatchesForCompetitions(competitionIds);

    }

}
