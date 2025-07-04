/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cnam.pronosport.pronosport.controller;

import fr.cnam.pronosport.pronosport.model.Sport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author networks
 */
public interface SportController {
    Sport getSportById(int id) throws Exception;
    List<Sport>  getAllSports() throws Exception;
    List<Sport> getTousSport() throws Exception;
    void addSport(Sport sport) throws Exception;
}
