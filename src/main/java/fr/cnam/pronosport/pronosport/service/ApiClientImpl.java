package fr.cnam.pronosport.pronosport.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import fr.cnam.pronosport.pronosport.dto.*;
import fr.cnam.pronosport.pronosport.model.Sport;
import fr.cnam.pronosport.pronosport.utils.UnsafeHttpClientFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class ApiClientImpl implements ApiClient {

    private static final String API_TOKEN = "be57b68b0d244466976639a28fcede6b"; // Mettre  le token

    public ApiClientImpl() {
        System.out.println("Hello from ApiClientImpl test");
    }

    @Override
    public ApiCompetitionDto[] getAllCompetitions() throws Exception {
         final Logger LOGGER = Logger.getLogger(ApiClientImpl.class.getName());

        // UnsafeHttpClientFactory sert à contrer la  vérification juste pour le développement
        HttpClient client = UnsafeHttpClientFactory.createUnsafeHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/competitions"))
                .header("X-Auth-Token", API_TOKEN)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        LOGGER.info("Status code: " + response.statusCode());
        LOGGER.info("Body: " + response.body());
        System.out.println(response.body());
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
    
    public ArrayList<Sport> getTousSport() {
        ArrayList<Sport> sportsArray = new ArrayList<>();
        Sport sport1 = new Sport("Football");
        Sport sport2 = new Sport("Tennis");
        Sport sport3 = new Sport("Rugby");
        Sport sport4 = new Sport("Basketball");
        Sport sport5 = new Sport("Natation");
        Sport sport6 = new Sport("Ski");
        Sport sport7 = new Sport("Badminton");
        Sport sport8 = new Sport("Volleyball");
        Sport sport9 = new Sport("Baseball");
        Sport sport10 = new Sport("Athlétisme");
        sportsArray.add(sport1);
        sportsArray.add(sport2);
        sportsArray.add(sport3);
        sportsArray.add(sport4);
        sportsArray.add(sport5);
        sportsArray.add(sport6);
        sportsArray.add(sport7);
        sportsArray.add(sport8);
        sportsArray.add(sport9);
        sportsArray.add(sport10);
        return sportsArray;
    }

    @Override
    public ApiAreaDto[] getAllArea() throws Exception {
        // À implémenter de façon similaire
        return new ApiAreaDto[0];
    }
}
