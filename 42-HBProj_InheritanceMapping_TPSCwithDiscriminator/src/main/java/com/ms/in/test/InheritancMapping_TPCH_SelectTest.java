package com.ms.in.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ms.in.entity.Customer;
import com.ms.in.entity.Employee;
import com.ms.in.entity.Person;
import com.ms.in.utility.HibernateUtil;

public class InheritancMapping_TPCH_SelectTest {

	public static void main(String[] args) {

		// create SessionFactory,Session obj
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		try (factory; ses) {
			// create HQL / JPQL query
			Query query1 = ses.createQuery("from Person");

			// Process the result
			List<Person> list = query1.getResultList();
			list.forEach(per -> {
				System.out.println(per);
			});
			System.out.println("========================================");
			
			Query query2 = ses.createQuery("from Employee");

			// Process the result
			List<Employee> list1 = query2.getResultList();
			list1.forEach(emp -> {
				System.out.println(emp);
			});
			System.out.println("========================================");
			
			Query query3 = ses.createQuery("from Customer");

			// Process the result
			List<Customer> list2 = query3.getResultList();
			list2.forEach(cust -> {
				System.out.println(cust);
			});
			System.out.println("========================================");
		} catch (HibernateException he) {
			he.printStackTrace();
		} // catch

		/*
		 * SessionFactory factory = HibernateUtil.getSessionFactory(); Session ses =
		 * HibernateUtil.getSession(); try (ses; factory) { Query query1 =
		 * ses.createQuery("FROM Person WHERE details.compony = ?1");
		 * query1.setParameter(1, "HCL"); // Process the result List<Person> list =
		 * query.getResultList(); List<Person> list1 = query1.getResultList();
		 * list1.forEach(ob -> { System.out.println("Person Detailes ");
		 * 
		 * System.out.println(ob.getPid() + " | " + ob.getPname() + " | " +
		 * ob.getAddr()); JobDetailes details = ob.getDetails();
		 * System.out.println("Job Detailes "); System.out.println(details.getDesg() +
		 * " | " + details.getSalary() + " | " + details.getCompony());
		 * System.out.println("-----------------------------------------------------");
		 * }); } catch (Exception e) { e.printStackTrace();
		 * 
		 * }
		 */
	}// main
}
// class
