package jkfitness.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	private static SessionFactory buildSessionFactory() {
	 SessionFactory sessionFactory = null;
	 try {
	   //Create the session factory object.
	  //return new  Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
	   sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
	 //  return sessionFactory;	
	 }
	 catch (Exception e) {
	  e.printStackTrace();
	 }
	 return sessionFactory;
	}
 
	public static SessionFactory getSessionFactory() {
	  return sessionFactory;
	}
 
}