
/*
 * 
 * This is the main application launcher class and acts as the entry point in the system.
 * This class is called by user to start the application.
 * The class requires the Filetype and XML FileName as command line arguments.
 * 
 */




package com.hitachi.application;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hitachi.objects.ParseElement;
import com.hitachi.util.*;
import com.hitachi.hibernate.entities.*;

public class AppLauncher {

	/**
	 * @param args
	 * @throws Exception 
	 */
	private static Logger logger;				//Initializes the logger.
	
	static{
        PropertyConfigurator.configure("log4j.properties");
        logger = Logger.getLogger(AppLauncher.class);
    }

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//Check to see if the type and file name is provided as arguments.
		
		if(args.length < 2) {
			System.out.println("Incorrect Number of arguments");
			logger.error("Incorrect Number of arguments");
			System.exit(0);
		}

		else{

			String type = args[0];
			String filename = args[1];
			Vector<ParseElement> elem = XmlParser.run(filename); //Call to XML Parser. The Parser returns a list of ParseElement objects.
			Iterator<ParseElement> iter = elem.iterator();

/*
 * Based on the input type, the function calls the populate function of the appropriate class. 			
 * After object creation, the object is passed to the HibernateDriver which maps it to the DB
 */
			
			if(type.equalsIgnoreCase("Arraygroup")){

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Arraygroup obj = new Arraygroup();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}

			else if(type.equalsIgnoreCase("Component")){
				System.out.println("Type is "+type);
				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Component obj = new Component();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("Externalstorage")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Externalstorage obj = new Externalstorage();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("hoststoragedomain")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					String hsdObjId;
					if(currElem.getElement().equalsIgnoreCase(type)){
						Hoststoragedomain obj = new Hoststoragedomain();
						obj.populate(currElem);
						hsdObjId = currElem.getAttribute().get("objectID");
						HibernateDriver.run(obj);
						
						//WWN is a table which has a Many to 1 relationship with HSD. 
						
						if(iter.hasNext() && iter.next().getElement().equalsIgnoreCase("WWN")){
							currElem = iter.next();
							Wwn wwnObj = new Wwn();
							wwnObj.populate(currElem,hsdObjId);
							HibernateDriver.run(wwnObj);
						}
					}
				}
			}
			
			else if(type.equalsIgnoreCase("ldev")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Ldev obj = new Ldev();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("logicalunit")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Logicalunit obj = new Logicalunit();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			
			else if(type.equalsIgnoreCase("path")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Path obj = new Path();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("pdev")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Pdev obj = new Pdev();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("pool")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Pool obj = new Pool();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("port")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Port obj = new Port();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("portcontroller")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Portcontroller obj = new Portcontroller();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("replicationinfo")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Replicationinfo obj = new Replicationinfo();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else if(type.equalsIgnoreCase("storagearray")) {

				while(iter.hasNext()){
					ParseElement currElem = (ParseElement)iter.next();
					if(currElem.getElement().equalsIgnoreCase(type)){
						Storagearray obj = new Storagearray();
						obj.populate(currElem);
						HibernateDriver.run(obj);
					}
				}
			}
			else {
				System.out.println("Incorrect FileType");
			}
		}

	}
}
