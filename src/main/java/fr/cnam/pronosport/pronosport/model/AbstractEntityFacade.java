package fr.cnam.pronosport.pronosport.model;

import fr.cnam.pronosport.pronosport.utils.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;


public abstract class AbstractEntityFacade<T> implements IEntityFacade<T> {
	
	private Session session = HibernateConnection.getInstance().getSession();
	

	@Override
	public T add(T entity) throws Exception {
		Transaction tx = session.beginTransaction();
		// rendre l�entit� persistante
		session.save(entity);
		tx.commit();
		return entity;
	}

	@Override
	public T get(Class<T> entity, Integer id) throws Exception {
		return session.get((Class<T>) entity, id);
	}

	@Override
	public void update(T entity) throws Exception {
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
	}

	@Override
	public void remove(T entity) throws Exception {
		Transaction tx = session.beginTransaction();
		session.remove(entity);
		tx.commit();
	}

	

}
 