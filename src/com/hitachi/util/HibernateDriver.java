/*
 * The HibernateDrive class calls the session save for saving the object in the Database. 
 * 
 */

package com.hitachi.util;

import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class HibernateDriver{

	//@Override
	private static Logger logger;
	
	static{
        PropertyConfigurator.configure("log4j.properties");
        logger = Logger.getLogger(HibernateDriver.class);
    }
	public static void run(Object c) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			
	        logger.info("Beginning Transaction");
	        session.beginTransaction();
	        session.save(c);
	        session.getTransaction().commit();
	        
		}catch (HibernateException e){
			System.out.println("Exception" + e);
			e.printStackTrace();
			logger.error(e);
		}
		finally{
			
			session.close();
		}
		
	}
	
	
}
