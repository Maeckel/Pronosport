/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cnam.pronosport.pronosport.service;


import fr.cnam.pronosport.pronosport.model.Sport;
import java.util.List;

/**
 *
 * @author networks
 */
public interface SportService {
    void importSportsFromApi() throws Exception;

    Sport getById(int id) throws Exception;

    List<Sport> getAll() throws Exception;

    void add(Sport sport) throws Exception;
}
