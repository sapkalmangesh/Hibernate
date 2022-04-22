package com.ms.in.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ms.in.entity.Customer;
import com.ms.in.entity.Employee;
import com.ms.in.entity.Person;
import com.ms.in.utility.HibernateUtil;

public class InheritanceMapping_TPHC_InsertTest {

	public static void main(String[] args) {
		// create SessionFactory,Session Obj
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try (ses; factory) {
			// prepare obj
			Person per = new Person();
			per.setPname("Rohit Sharma");
			per.setAddr("Mumbai");

			Employee emp = new Employee();
			emp.setPname("Shreyash Ayyer");
			emp.setAddr("Kolkatta");
			emp.setDesg("Batsman");
			emp.setSalary(900000.0);
			emp.setCompony("HCL");

			Customer cust = new Customer();
			cust.setPname("MSD");
			cust.setAddr("Chennai");
			cust.setBillAmt(2563.0);
			cust.setBillNo(1234);

			// begin transaction

			tx = ses.beginTransaction();
			ses.save(per);
			ses.save(emp);
			ses.save(cust);

			// commite the transaction
			tx.commit();
			System.out.println("Objects are saved....!");
		} catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem occures in saving object...");
			}//if

		}//catch

	}//main

}//class
