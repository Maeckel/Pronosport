/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cnam.pronosport.pronosport.service;

import fr.cnam.pronosport.pronosport.dto.ApiSportDto;
import fr.cnam.pronosport.pronosport.model.Sport;
import fr.cnam.pronosport.pronosport.repository.SportRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author networks
 */
public class SportServiceImpl implements SportService {
    
    private SportRepository sportRepository;
    private ApiClient apiClient;
    
    public SportServiceImpl(SportRepository sportRepository, ApiClient apiClient) {
        this.sportRepository = sportRepository;
        this.apiClient = apiClient;
    }


    public SportServiceImpl() {
    }

        @Override
        public void importSportsFromApi() throws Exception {
            // 1. Appel à l’API externe
            //List<ApiSportDto> apiSports = List.of(apiClient.getAllSports());
            ApiClientImpl apiClient = new ApiClientImpl();
            ArrayList<Sport> liste = apiClient.getTousSport();

            // 2. Transformation et persistence
            /**for (ApiSportDto apiSport : apiSports) {
                //Pour chaque compétition récupéré on instancie un objet de type Competition à persisiter dans la base
                Sport sport = new Sport();

                sport.setNom(apiSport.getNom());

                // 3. Persistance dans la base de données
                this. add(sport); **/
                
                for (Sport unsport : liste) {
                //Pour chaque compétition récupéré on instancie un objet de type Competition à persisiter dans la base
                
                System.out.println(unsport);
                // 3. Persistance dans la base de données
                
                this.add(unsport);

            }
        }


    @Override
    public Sport getById(int id) throws Exception {

        return sportRepository.getSportById(id);
    }


    @Override
    public List<Sport> getAll() throws Exception {
       // return sportRepository.getAllSports();
       return sportRepository.getTousSport();
    }


    @Override
    public void add(Sport sport) throws Exception {
        if(sportRepository != null){
            sportRepository.addSport(sport);
        }
    }

}
