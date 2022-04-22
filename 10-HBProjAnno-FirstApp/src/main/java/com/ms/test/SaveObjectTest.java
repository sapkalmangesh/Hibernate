package com.ms.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ms.entity.Movie;
import com.ms.utility.HibernateUtil;

public class SaveObjectTest {
	public static void main(String[] args) {
		//get SessionFactory Object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//get Session object
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses;factory){
			//begin tx
			tx=ses.beginTransaction();
			//prepare obj
			Movie movie = new Movie(3000,"Pushpa","Allu_Arjun","Rashmika",400.0f);
			//save obj
			ses.save(movie);
			//commite tx
			tx.commit();
			System.out.println("Object is saved");
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			e.printStackTrace();
		}//catch

	}//main

}//class
