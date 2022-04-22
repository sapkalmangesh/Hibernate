package com.ms.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ms.entity.Stock;
import com.ms.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//get session obj
		Session ses = factory.openSession();
		Transaction tx = null;
		try(factory;ses){
			//begin tx
			tx=ses.beginTransaction();
			//prepare obj
			Stock stock = new Stock("Tata",100.0,"NSE");
			int Idval=(int) ses.save(stock);
			tx.commit();
			System.out.println("Object/record is saved with id value"+Idval);
			System.out.println("Object/record is updated with id value"+stock.getLastUpdate());

		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!= null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object/record is not saved");
			}//
		}//catch
	}//main
}//class
