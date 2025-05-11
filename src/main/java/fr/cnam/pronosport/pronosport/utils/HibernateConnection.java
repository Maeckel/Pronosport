package fr.cnam.pronosport.pronosport.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	private static HibernateConnection instance;
	private static SessionFactory sessionFactory;

	private HibernateConnection() throws HibernateException {
		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();


			System.out.println("Hibernate Configuration Loaded:");
			System.out.println("User: " + configuration.getProperty("hibernate.connection.username"));
			System.out.println("URL: " + configuration.getProperty("hibernate.connection.url"));

		} catch (HibernateException e) {
			System.err.println("Erreur de configuration Hibernate: " + e.getMessage());
			throw e;
		}
	}

	public static synchronized HibernateConnection getInstance() throws HibernateException {
		if (instance == null) {
			instance = new HibernateConnection();
		}
		return instance;
	}

	public Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static void shutDown() throws HibernateException {
		sessionFactory.close();
	}
}
