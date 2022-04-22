package com.in.ms.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.in.ms.entity.Product;
import com.in.ms.utility.HibernateUtil;

public class SimplePeginationTest {

	public static void main(String[] args) {
		//Create SessionFactory Obj
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//create Session Object
		Session ses = HibernateUtil.getSession();
		try(factory;ses) {
			//create HQL query
			Query query = ses.createQuery("from Product");
			//Pegination start postion
			query.setFirstResult(5);
			query.setMaxResults(3);

			//execute query
			List<Product> list = query.getResultList();
			list.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}
}
