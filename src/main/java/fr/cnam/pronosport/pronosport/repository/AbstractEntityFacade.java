package fr.cnam.pronosport.pronosport.repository;

import fr.cnam.pronosport.pronosport.utils.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/*
Documentation:
https://hibernate.org/orm/quickly/#2-insert
Cette classe  Abstraite permet de définir des méthodes  dite du CRUD (CREATE, READ, UPDATE, DELETE) et d' intéragir avec la base de donnée
la Balise  <T> permet de définir une classe générique et permet d'avoir une classe modulable en définissant l'entité plus precisément l'objet à persisté
* */


public abstract class AbstractEntityFacade<T> implements IEntityFacade<T> {
	
	//private Session session = HibernateConnection.getInstance().getSession();




		@Override
		public T add(T entity) throws Exception {
			Transaction tx = null;
			try (Session session = HibernateConnection.getInstance().getSession()) {
				tx = session.beginTransaction();
				session.persist(entity);
				tx.commit();
				return entity;
			} catch (Exception e) {
				if (tx != null) tx.rollback();
				throw e;
			}
		}




		@Override
		public T get(Class<T> entityClass, Integer id) throws Exception {
			try (Session session = HibernateConnection.getInstance().getSession()) {
				return session.get(entityClass, id);
			}
		}


	public List<T> getAll(Class<T> entityClass) throws Exception {
		try (Session session = fr.cnam.pronosport.pronosport.utils.HibernateConnection.getInstance().getSession()) {
			return session.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
		}
	}
		@Override
		public void update(T entity) throws Exception {
			Transaction tx = null;
			try (Session session = HibernateConnection.getInstance().getSession()) {
				tx = session.beginTransaction();
				session.merge(entity);
				tx.commit();
			} catch (Exception e) {
				if (tx != null) tx.rollback();
				throw e;
			}
		}

		@Override
		public void remove(T entity) throws Exception {
			Transaction tx = null;
			try (Session session = HibernateConnection.getInstance().getSession()) {
				tx = session.beginTransaction();
				session.remove(entity);
				tx.commit();
			} catch (Exception e) {
				if (tx != null) tx.rollback();
				throw e;
			}
		}

	}

 