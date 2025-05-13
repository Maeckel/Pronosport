package fr.cnam.pronosport.pronosport.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import fr.cnam.pronosport.pronosport.dto.*;
import fr.cnam.pronosport.pronosport.utils.UnsafeHttpClientFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.logging.Logger;

public class ApiClientImpl implements ApiClient {

    private static final String API_TOKEN = ""; // Mettre  le token

    public ApiClientImpl() {
        System.out.println("Hello from ApiClientImpl test");
    }

    @Override
    public ApiCompetitionDto[] getAllCompetitions() throws Exception {
         final Logger LOGGER = Logger.getLogger(ApiClientImpl.class.getName());


        HttpClient client = UnsafeHttpClientFactory.createUnsafeHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/competitions"))
                .header("X-Auth-Token", API_TOKEN)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        LOGGER.info("Status code: " + response.statusCode());
        LOGGER.info("Body: " + response.body());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erreur API football-data: " + response.statusCode() + " - " + response.body());
        }

        // La réponse est un objet JSON avec un champ "competitions"
        Gson gson = new Gson();
        JsonObject root = gson.fromJson(response.body(), JsonObject.class);
        JsonArray competitionsArray = root.getAsJsonArray("competitions");

        return gson.fromJson(competitionsArray, ApiCompetitionDto[].class);
        
        //ATTENTION RECUPERER   zone / type / area.name
    }

    @Override
    public ApiMatchDto[] getAllMatchs() throws Exception {
        // À implémenter de façon similaire
        return new ApiMatchDto[0];
    }

    @Override
    public ApiTeamDto[] getAllTeams() throws Exception {
        // À implémenter de façon similaire
        return new ApiTeamDto[0];
    }

    @Override
    public ApiSportDto[] getAllSports() throws Exception {
        // À implémenter de façon similaire
        return new ApiSportDto[0];
    }

    @Override
    public ApiAreaDto[] getAllArea() throws Exception {
        // À implémenter de façon similaire
        return new ApiAreaDto[0];
    }
}
