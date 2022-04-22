package com.ms.in.client;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ms.in.entity.PrgmrProjId;
import com.ms.in.entity.ProgrammerProjectInfo;
import com.ms.in.utility.HibernateUtil;
import com.sun.xml.txw2.output.TXWSerializer;

public class SaveObjectTest {

	public static void main(String[] args) {
		//create SessionFactory obj
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//create Session object
		Session ses = HibernateUtil.getSession();
		Transaction tx= null;
		try(ses;factory){
			//begin tx
			tx=ses.beginTransaction();
			//cteate PrgmrProjId obj
			PrgmrProjId id = new PrgmrProjId(101,1001);
			//create ProgramerProjectInfo obj
			ProgrammerProjectInfo Info = new ProgrammerProjectInfo
					(id,"Shiv",60000.0,"OprnFx",5000000.0);
			PrgmrProjId idVal= (PrgmrProjId) ses.save(Info);
			tx.commit();
			System.out.println("Object/record is saved with id value "+idVal);
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("object/ record is not saved");
			}//if
		}//catch
	}//main
}//class
