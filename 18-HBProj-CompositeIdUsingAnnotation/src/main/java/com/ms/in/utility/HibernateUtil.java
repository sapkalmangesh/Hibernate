package com.ms.in.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory= null;
	static {
		//prepare cfg object
		Configuration cfg= new Configuration();
		//configure cfgs file
		cfg.configure("com/ms/in/cfgs/hibernate.cfg.xml");
		//create session factory object
		factory=cfg.buildSessionFactory();
	}
	//static factory method for SessionFactory object
	public static SessionFactory getSessionFactory() {
		return factory;
	}

	//static session method for Session object
	public static Session getSession() {
		Session ses = null;
		if(factory!=null) {
			ses=factory.openSession();
		}
		return ses;
	}

}
