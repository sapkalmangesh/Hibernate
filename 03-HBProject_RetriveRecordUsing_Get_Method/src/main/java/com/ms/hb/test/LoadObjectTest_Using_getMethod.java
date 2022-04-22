package com.ms.hb.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ms.hb.entity.Product;

public class LoadObjectTest_Using_getMethod {
	public static void main(String[] args) {
		//Configuration ogj
		Configuration cfg = new Configuration();
		//configure cfgs file
		cfg.configure("com/ms/hb/cfgs/Hibernate.cfg.xml");
		//build Session factory
		SessionFactory factory = cfg.buildSessionFactory();
		//build session obj
		Session ses = factory.openSession();
		try(factory;ses){//try with resource
			Product prod = ses.get(Product.class,101);
			
			if(prod==null)
				System.out.println("Record not found");
			else
				System.out.println(prod);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();  
		}//catch
	}//main

}//class
