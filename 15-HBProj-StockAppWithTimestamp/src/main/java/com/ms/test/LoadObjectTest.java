package com.ms.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ms.entity.Stock;
import com.ms.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//get session obj
		Session ses = factory.openSession();
		Transaction tx = null;
		try(factory;ses){
			//load obj
			Stock stock = ses.get(Stock.class,1);
			if(stock==null) {
				System.out.println("record not found...");
				return;
			}
			else {
				//begin tx
				tx=ses.beginTransaction();
				//update value
				stock.setStockPrice(200.0);
				stock.setExchange("BSE");
				ses.update(stock);
				tx.commit();
				System.out.println("Object/record is lastely update at  "+stock.getLastUpdate());
			}
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!= null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object/record is not updated");
			}//
		}//catch
	}//main
}//class
