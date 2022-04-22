package com.ms.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		System.out.println("Hibernate util--static block ");
		//create configuration obj
		Configuration cfg= new Configuration();
		//cofigure cfgs file
		cfg.configure("com/ms/cfgs/hibernate.cfg.xml");
		//create session factory object
		factory=cfg.buildSessionFactory();
	}
	//satic factory method for SessionFactory obj
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	//static Session method for Session obj
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) { 
			ses=factory.openSession();
		}
			return ses;
	}
	

}


