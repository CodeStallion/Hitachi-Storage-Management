/*
 * The HibernateUtil class instantiates the hibernate session. 
 * 
 */


package com.hitachi.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial Session Factory Creation Failed" + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
