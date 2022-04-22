package com.ms.in.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ms.in.entity.Customer;
import com.ms.in.entity.Employee;
import com.ms.in.entity.Person;
import com.ms.in.utility.HibernateUtil;

public class InheritanceMapping_TPCC_InsertTest {

	public static void main(String[] args) {
		// create SessionFactory,Session Obj
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try (ses; factory) {
			// prepare obj
			Person per = new Person();
			per.setPname("Shikhar Dhawan");
			per.setAddr("Delhi");

			Employee emp = new Employee();
			emp.setPname("Tilak Verma");
			emp.setAddr("Mumbai");
			emp.setDesg("Batsman");
			emp.setSalary(900000.0);
			emp.setCompony("MumbaiIndians");

			Customer cust = new Customer();
			cust.setPname("Teem Southee");
			cust.setAddr("NewZeland");
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
