package fr.cnam.pronosport.pronosport.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.out;

@WebServlet(name = "MatchServlet", value = "/matches-servlet")
public class MatchServlet extends HttpServlet {


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String[] selectedCompetitionsId = request.getParameterValues("competition");
            request.setAttribute("CompetitionsId", selectedCompetitionsId);
            // Les différent id des compétitions  sont partagé ici et envoyé à match.jsp
            System.out.println("selectedCompetitionsId: " + Arrays.toString(selectedCompetitionsId));
            // parsInt parceque l'on a un array de String
            request.getRequestDispatcher("matches.jsp").forward(request, response);
        }
    }


