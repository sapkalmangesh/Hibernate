package com.ms.in.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.ms.in.entity.Product;
import com.ms.in.utility.HibernateUtil;

public class Named_Native_Sql_Query {

	public static void main(String[] args) {
		// create SessionFactory object
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// cteate Session object
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		// get access to NamedNative query1
		try (factory; ses) {
			// write NamedNativeQuery
			NativeQuery query1 = ses.getNamedNativeQuery("GET_RECORD_BY_PRICE_RANGE");

			// maped Entity query result with Entity class
			query1.addEntity(Product.class);

			// set query parameter
			query1.setParameter(1, 1000.0);
			query1.setParameter(2, 9000.0);

			// execute query
			List<Product> list = query1.getResultList();

			// process the result
			list.forEach(prod -> {
				System.out.println(prod);
				System.out.println("------------------------------------------------");
			});
			System.out.println("====================================================");
			tx = ses.beginTransaction();
			// get access to NamedNative query1
			NativeQuery query2 = ses.getNamedNativeQuery("UPDATE_PRICE_BY_PRODUCT");

			// set query param
			query2.setParameter(1, 500.0);
			query2.setParameter(2, "Iron");

			// execute the query
			int count = query2.executeUpdate();
			System.out.println(count + " record are updated");

		} catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				System.out.println("Record not updated ");
				tx.rollback();
			}//if
			
		}//catch

	}//main

}//class
