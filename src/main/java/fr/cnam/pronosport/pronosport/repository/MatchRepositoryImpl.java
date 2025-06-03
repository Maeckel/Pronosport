package fr.cnam.pronosport.pronosport.repository;

import fr.cnam.pronosport.pronosport.model.Match;
import fr.cnam.pronosport.pronosport.utils.HibernateConnection;
import org.hibernate.Session;

import java.util.List;

public class MatchRepositoryImpl extends AbstractEntityFacade<Match> implements MatchRepository {

    @Override
    public Match getMatchById(int id) {
        try (Session session = HibernateConnection.getInstance().getSession()) {
            return session.createQuery("from Match where id = :id", Match.class)
                    .setParameter("id", id)
                    .uniqueResult(); // uniqueResult() évite l'exception si aucun résultat
        }
    }


    @Override
    public List<Match> getAllMatchs() throws Exception {
        return this.getAll(Match.class); // Appelle la méthode générique de la classe abstraite
    }

    @Override
    public void addMatch(Match match) throws Exception {
        this.add(match); // Utilise la méthode de la classe abstraite (qui gère bien la session)
    }

    

    // requête  spécifique à la compétition et au match
    /*List<Object[]> getMatchesFromCompetition(Competition competition) {
        Session session= HibernateConnection.getInstance().getSession();
        return session.createQuery("SELECT c,m FROM Competition c JOIN c.matche m",Object [].class).getResultList();
     }*/

    @Override
    public List<Match> getMatchesForCompetitions(List<Integer> competitionIds) {
        Session session = HibernateConnection.getInstance().getSession();

    return session.createQuery(
        "SELECT m FROM Match m WHERE m.competition.id IN :competitionIds", 
        Match.class
    )
    .setParameterList("competitionIds", competitionIds)
    .getResultList();
}
        
    


}
