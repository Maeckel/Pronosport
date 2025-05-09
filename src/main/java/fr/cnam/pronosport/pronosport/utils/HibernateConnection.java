package fr.cnam.pronosport.pronosport.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	private static HibernateConnection instance;
	private static SessionFactory sessionFactory;

	private HibernateConnection() throws HibernateException {
		if (sessionFactory == null) {
//			File f = new File("C:\\WS_JAR\\hibernate.cfg.xml");
//			File f = new File("C:\\Users\\romss\\Documents\\romain_windows_7\\Tuto\\Programmation\\projet_to_deploy\\Akte08062021\\target\\classes\\hibernate.cfg.xml");
//			sessionFactory = new Configuration().configure(f).buildSessionFactory();
			sessionFactory = new Configuration().configure().buildSessionFactory();

//			Properties dbConnectionProperties= new Properties();
//			try {
//				dbConnectionProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
		}
	}

	// Design pattern Singleton

	public static synchronized HibernateConnection getInstance() throws HibernateException {

		if (instance == null) {
			instance = new HibernateConnection();
		}
		return instance;
	}

	public Session getSession() throws HibernateException {
		Session session = sessionFactory.openSession();
		if (!session.isConnected()) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void shutDown() throws HibernateException {
		sessionFactory.close();
	}
}
