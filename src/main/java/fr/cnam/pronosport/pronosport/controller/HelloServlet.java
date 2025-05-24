package fr.cnam.pronosport.pronosport.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    private CompetitionController competitionController;

    public HelloServlet() {
        System.out.println("HelloServlet instancié !");
    }

    //TestMySQLConnection con = new TestMySQLConnection();
    @Override
    public void init() {
        DisableSslVerification.disable();
        // Initialisation en une seule fois
        ApiClient apiClient = new ApiClientImpl();
        CompetitionRepository repository = new CompetitionRepositoryImpl();
        CompetitionService service = new CompetitionServiceImpl(repository, apiClient);

        // Import des compétitions depuis l'API
        try {
            service.importCompetitionsFromApi();
        } catch (Exception e) {
            e.printStackTrace();
        }

        competitionController = new CompetitionControllerImpl(service);

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // tester la connection à la base de donnée
            /*try (Connection conn = TestMySQLConnection.getConnection()) {
                //conn.prepareStatement("create table");
                //response.getWriter().println("Connexion réussie !");
            } catch (SQLException e) {
                response.getWriter().println("Erreur de connexion : " + e.getMessage());
            }*/

        try {
            // connection à la base de donnée et mapping avec hibernate
            response.getWriter().println("Connexion hibernate réussie ! ");
            HibernateConnection.getInstance().getSession();
        } catch (Exception e) {
            response.getWriter().println("Erreur de connexion : " + e.getMessage());

        }

        try {
            // Simule une demande  voir la liste des compétitions
            List<String> ZoneNames = new ArrayList<String>();

            List<Competition> competitions = competitionController.getAllCompetitions();


            request.setAttribute("competitions", competitions);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("competitions.jsp");
            requestDispatcher.forward(request, response);
            // Renvois les compétitions en JSON
            //response.getWriter().write(new Gson().toJson(competitions));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }


    }
}