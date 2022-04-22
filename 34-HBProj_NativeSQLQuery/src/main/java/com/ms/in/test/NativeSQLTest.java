//Native SQL queries result in the form of Object type Object[]

package com.ms.in.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.ms.in.utility.HibernateUtil;

public class NativeSQLTest {
	public static void main(String[] args) {
		// create SessionFactoty Object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// cteate Session Object
		Session ses = HibernateUtil.getSession();
		try (ses; factory) {
			// write Native sql query
			NativeQuery query = ses.createNativeQuery("SELECT * FROM PRODUCT");
			List<Object[]> list = query.getResultList();
			list.forEach(record -> {
				for (Object val : record) {
					System.out.println(val+"  ");
				}
				System.out.println("----------------------------------------------------------");
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}//main

}//class
