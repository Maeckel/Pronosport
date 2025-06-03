/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cnam.pronosport.pronosport.repository;

import fr.cnam.pronosport.pronosport.model.Sport;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author networks
 */
public class SportRepositoryImpl extends AbstractEntityFacade<Sport> implements SportRepository {
    
    @Override
    public Sport getSportById(int id) {
        try (Session session = fr.cnam.pronosport.pronosport.utils.HibernateConnection.getInstance().getSession()) {
            return session.createQuery("from Sport where id = :id", Sport.class)
                    .setParameter("id", id)
                    .uniqueResult(); // uniqueResult() évite l'exception si aucun résultat
        }
    }

    @Override
    public List<Sport> getAllSports() throws Exception {
        return this.getAll(Sport.class); // Appelle la méthode générique de la classe abstraite
    }
    
    @Override
    public List<Sport> getTousSport() throws Exception {
        return this.getAll(Sport.class); // Appelle la méthode générique de la classe abstraite
    }

    @Override
    public void addSport(Sport sport) throws Exception {
        this.add(sport); // Utilise la méthode de la classe abstraite (qui gère bien la session)
    }
    
}
