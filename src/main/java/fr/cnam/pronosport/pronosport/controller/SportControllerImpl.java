/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.model.Sport;
import fr.cnam.pronosport.pronosport.service.SportService;
import java.util.List;

/**
 *
 * @author networks
 */
public class SportControllerImpl implements SportController {
    
    //Le contrôleur (ici, CompetitionControllerImpl) reçoit les requêtes (par exemple, d’une servlet ou d’un endpoint REST).

    private  final SportService sportService ;

    public SportControllerImpl(SportService sportService) {
        this.sportService = sportService;

    }

    @Override
    public Sport getSportById(int id) throws Exception {

        return sportService.getById(id);
    }

    @Override
    public List<Sport> getAllSports() throws Exception {

        return  sportService.getAll();
    }
    
    @Override
    public List<Sport> getTousSport() throws Exception {

        return  sportService.getAll();
    }

    @Override
    public void addSport(Sport sport) throws Exception {
        sportService.add(sport);
    }
    
}
