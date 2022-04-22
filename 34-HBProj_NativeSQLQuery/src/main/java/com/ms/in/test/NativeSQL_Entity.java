/*Native SQL query result must be mapped with entity class 
ie.addEntity(Product.class);
*/
package com.ms.in.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.ms.in.entity.Product;
import com.ms.in.utility.HibernateUtil;

public class NativeSQL_Entity {
	public static void main(String[] args) {
		// create SessionFactoty Object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// cteate Session Object
		Session ses = HibernateUtil.getSession();
		try (ses; factory) {
			// write Native sql query
			NativeQuery query = ses.createNativeQuery("SELECT * FROM PRODUCT");
			query.addEntity(Product.class);
			List<Product> list = query.getResultList();
			list.forEach(prod -> {
				System.out.println(
						prod.getPid() + "  " + prod.getPname() + "  " + prod.getPrice() + "  " + prod.getQty());
				System.out.println("----------------------------------------------------------");
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}// main

}// class
