package fr.cnam.pronosport.pronosport.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.cnam.pronosport.pronosport.model.Competition;
import fr.cnam.pronosport.pronosport.repository.CompetitionRepository;
import fr.cnam.pronosport.pronosport.repository.CompetitionRepositoryImpl;
import fr.cnam.pronosport.pronosport.service.ApiClient;
import fr.cnam.pronosport.pronosport.service.ApiClientImpl;
import fr.cnam.pronosport.pronosport.service.CompetitionService;
import fr.cnam.pronosport.pronosport.service.CompetitionServiceImpl;
import fr.cnam.pronosport.pronosport.utils.DisableSslVerification;
import fr.cnam.pronosport.pronosport.utils.HibernateConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/*
    Cheminement: Contrôleur  --->  Service  --->  Repository  --->  Base de données

    Le contrôleur reçoit la requête (par exemple, d’une servlet, d’un endpoint REST ou d’une interface graphique).

    Le service fait tout le travail métier (appels repository, transformation, logique métier).

    Le repository ne sert qu’à accéder à la base de données.

*/

    @WebServlet(name = "CompetitionServlet", value = "/competition-servlet")
public class CompetitionServlet extends HttpServlet {
    private String message;

    private CompetitionController competitionController;

    public CompetitionServlet() {
            System.out.println("Competition servlet instancié !");
    }

    //TestMySQLConnection con = new TestMySQLConnection();
    @Override
    public void init() {
        //Désactivation de la verification ssl juste pour le developpement
        DisableSslVerification.disable();


        // Initialisation en une seule fois
        // création des instances apiClient et repository
        ApiClient apiClient = new ApiClientImpl();
        CompetitionRepository repository = new CompetitionRepositoryImpl();

        /*Injection de dépendance  bonne pratique évite le couplage fort c'est à dire dépendance d'une classe par rapport à une autre (éviter de créer une instance d' une classe dans la classe qui en a besoin pour faire ses opérations
         Ici on utilise le constructeur de  CompetitionServiceImpl pour injecter l'objet repository et apiClient en tant qu'argument pour que l'objet de la classe CompetitionServiceImpl puisse appeler les methodes  comme par exemple
         competitionRepository.getAllCompetitions() ou toute autre method liée à cette classe  ( Pour comprendre voir dans la classe   la déclaration de competitionRepository et ou est utilisé competitionRepository.getAllCompetitions()*/
        CompetitionService service = new CompetitionServiceImpl(repository, apiClient);

        // Import des compétitions depuis l'API
        /*try {
            service.importCompetitionsFromApi();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        competitionController = new CompetitionControllerImpl(service);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try {
            // Simule une demande  voir la liste des compétitions

            List<Competition> competitions = competitionController.getAllCompetitions();

            // regroupe les compétitions par zone
            Map<String, List<Competition>> competitionsParZone = competitions.stream()
                    .collect(Collectors.groupingBy(Competition::getZone));


            request.setAttribute("competitionsParZone", competitionsParZone);


            RequestDispatcher requestDispatcher = request.getRequestDispatcher("competitions.jsp");
            requestDispatcher.forward(request, response);
            //Pour tester:
            // Renvois les compétitions en JSON
            //response.getWriter().write(new Gson().toJson(competitions));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


}