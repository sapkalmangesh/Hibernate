package com.ms.in.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ms.in.entity.PersonDetails;
import com.ms.in.utility.HibernateUtil;

public class CollectionMappingTest {

	public static void main(String[] args) {
		// create SessionFactory, Session obj
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try (ses;factory){
			//begin transaction
			tx=ses.beginTransaction();
			//prepared obj
			PersonDetails details = new PersonDetails();
			details.setPname("Mahesh");
			details.setAddr("Delhi");
			details.setNickname(List.of("Major","Manty"));
			details.setFriends(List.of("Mangesh","Amol"));
			details.setContactNo(Set.of(9766447080L,97300000971L));
			details.setIdDetails(Map.of("VoterCard",7845129658L,"Aadhar",784512369885L));
			
			int id = (int) ses.save(details);
			System.out.println("Object is Saved with id "+id);
			
		} catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
				tx.commit();
			System.out.println("object is not saved");
		}
		
	}

}
