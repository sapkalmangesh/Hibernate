package com.in.ms.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.in.ms.entity.Product;
import com.in.ms.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		//get sessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session Object
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses) {
			//cteate query
			Query query = ses.createNamedQuery("GET_PRODUCT_RECORD_BY_PRICE_RANGE");
			//set parameter to query
			query.setParameter("min", 5000.0);
			query.setParameter("max", 25000.0);
			//gather the result
			List<Product> list=query.getResultList();
			list.forEach(System.out::println);
			
			//get access NamedHQL Non-select query
			tx=ses.beginTransaction();
			//create Query
			Query query1 = ses.createNamedQuery("INCRESE_PRODUCT_BY_PRICE_RANGE");
			//set parameter
			query1.setParameter("newValue",200.00);
			query1.setParameter("range",20000.0);
			
			//execute the queryy
			int count = query1.executeUpdate();
			System.out.println(count+"  records are updated");
			tx.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("problem occured to execute the query...");
			}//if
		}//catch
	}//main
}//class
