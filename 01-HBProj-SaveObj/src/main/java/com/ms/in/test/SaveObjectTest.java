package com.ms.in.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ms.in.entity.Product;

public class SaveObjectTest {
	public static void main(String[] args) {
		// Bootstrap/activate the hibernate
		Configuration cfg = new Configuration();
		//specify the hibernate cfg file name and location
		cfg.configure("com/ms/in/cfgs/hibernate.hbm.xml");
		//build SessionFactory having all services specified in mapping and cfg file
		SessionFactory factory = cfg.buildSessionFactory();
		//create session obj
		Session ses = factory.openSession();

		Transaction tx = null;
		try {
			//begin transaction
			tx = ses.beginTransaction();

			//prepare entity obj
			Product prod = new Product();
			prod.setpId(101);
			prod.setpName("Table");
			prod.setPrice(2500.0f);
			prod.setQty(2);

			//save object
			ses.save(prod);
			tx.commit();
			System.out.println("Object is saved(Record is inserted)");

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved(record not inserted)");

		}
		//close session obj
		ses.close();

		//close factory obj
		factory.close();
	}

}
