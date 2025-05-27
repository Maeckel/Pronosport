package fr.cnam.pronosport.pronosport.repository;

import fr.cnam.pronosport.pronosport.model.Competition;
import fr.cnam.pronosport.pronosport.utils.HibernateConnection;
import org.hibernate.Session;

import java.util.List;

public class CompetitionRepositoryImpl extends AbstractEntityFacade<Competition> implements CompetitionRepository {

    @Override
    public Competition getCompetitionById(int id) {
        try (Session session = HibernateConnection.getInstance().getSession()) {
            return session.createQuery("from Competition where id = :id", Competition.class)
                    .setParameter("id", id)
                    .uniqueResult(); // uniqueResult() évite l'exception si aucun résultat
        }
    }

    @Override
    public List<Competition> getAllCompetitions() throws Exception {
        return this.getAll(Competition.class); // Appelle la méthode générique de la classe abstraite
    }

    @Override
    public void addCompetition(Competition competition) throws Exception {
        this.add(competition); // Utilise la méthode de la classe abstraite (qui gère bien la session)
    }

    @Override
    public List<String> getAllZones() throws Exception {
        try (Session session = HibernateConnection.getInstance().getSession()) {
            return session.createQuery("from Competition c select c.zone",String.class).getResultList();
        }

    }

    // requête  spécifique à la compétition et au match
    /*List<Object[]> getMatchesFromCompetition(Competition competition) {
        Session session= HibernateConnection.getInstance().getSession();
        return session.createQuery("SELECT c,m FROM Competition c JOIN c.matche m",Object [].class).getResultList();
     }*/


}
