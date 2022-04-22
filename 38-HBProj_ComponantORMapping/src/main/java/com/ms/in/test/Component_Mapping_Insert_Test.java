package com.ms.in.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ms.in.entity.JobDetailes;
import com.ms.in.entity.Person;
import com.ms.in.utility.HibernateUtil;

public class Component_Mapping_Insert_Test {

	public static void main(String[] args) {
		// get Session, SessionFactory obj
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try (ses; factory) {
			// begin txns
			tx = ses.beginTransaction();
			// prepare JobDetails Object
			JobDetailes details = new JobDetailes();
			details.setDesg("Tester");
			details.setCompony("Cognizant");
			details.setSalary(90000.0);

			// prepare Person Obj
			Person person = new Person();
			person.setPname("Tanu");
			person.setAddr("Banglore");
			person.setDetails(details);

			Integer idVal = (Integer) ses.save(person);
			System.out.println("Person saved with Id'" + idVal + "'");

			// commite the query
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				System.out.println("Problem occurs to insert record");
				tx.rollback();
			}
		}

	}

}
