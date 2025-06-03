/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.model.Sport;
import fr.cnam.pronosport.pronosport.repository.SportRepository;
import fr.cnam.pronosport.pronosport.repository.SportRepositoryImpl;
import fr.cnam.pronosport.pronosport.service.ApiClient;
import fr.cnam.pronosport.pronosport.service.ApiClientImpl;
import fr.cnam.pronosport.pronosport.service.SportService;
import fr.cnam.pronosport.pronosport.service.SportServiceImpl;
import fr.cnam.pronosport.pronosport.utils.DisableSslVerification;
import fr.cnam.pronosport.pronosport.utils.HibernateConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author networks
 */
@WebServlet(name = "sportServlet", value = "/sport-servlet")
public class SportServlet extends HttpServlet {
    
    private String message;

    private SportController sportController;

    public SportServlet() {
        System.out.println("SportServlet instancié !");
    }

    //TestMySQLConnection con = new TestMySQLConnection();
    @Override
    public void init() {
        DisableSslVerification.disable();
        // Initialisation en une seule fois
        ApiClient apiClient = new ApiClientImpl();
        SportRepository repository = new SportRepositoryImpl();
        SportService service = new SportServiceImpl(repository, apiClient);

        // Import des compétitions depuis l'API
        try {
            service.importSportsFromApi();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sportController = new SportControllerImpl(service);

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
            
            SportServiceImpl liste = new SportServiceImpl();
            liste.importSportsFromApi();
            List<Sport> sports = sportController.getTousSport();

            request.setAttribute("sports", sports);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("sports.jsp");
            requestDispatcher.forward(request, response);
            // Renvois les compétitions en JSON
            //response.getWriter().write(new Gson().toJson(sports));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }


    }
    
}
