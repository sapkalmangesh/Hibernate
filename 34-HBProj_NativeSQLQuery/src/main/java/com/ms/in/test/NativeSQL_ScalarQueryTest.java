//Native SQL queries result in the form ScalarQuery

package com.ms.in.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.ms.in.utility.HibernateUtil;

public class NativeSQL_ScalarQueryTest {
	public static void main(String[] args) {
		// create SessionFactoty Object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// cteate Session Object
		Session ses = HibernateUtil.getSession();
		try (ses; factory) {
			// write Native sql query
			NativeQuery query = ses.createNativeQuery("SELECT PNAME,QTY FROM PRODUCT WHERE PRICE BETWEEN ? AND ?");
			//map scalar query result with hibernate datatype
			query.addScalar("PNAME",StandardBasicTypes.STRING);
			query.addScalar("QTY",StandardBasicTypes.INTEGER);
			//set query param value
			query.setParameter(1,200.0);
			query.setParameter(2,5000.0);
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
