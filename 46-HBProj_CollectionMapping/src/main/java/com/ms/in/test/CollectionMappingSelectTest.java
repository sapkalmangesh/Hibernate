package com.ms.in.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ms.in.entity.PersonDetails;
import com.ms.in.utility.HibernateUtil;

public class CollectionMappingSelectTest {

	public static void main(String[] args) {
		// Create SessionFactory, session object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		try (ses; factory) {
			// execute HQL query
			Query query = ses.createQuery("from PersonDetails");
			List<PersonDetails> list = query.getResultList();
			list.forEach(pd -> {
				System.out.println("Perosn Details are :" + pd.getPid() + "  " + pd.getPname() + "  " + pd.getAddr());
				List<String> nickname = pd.getNickname();
				System.out.println("Nicknames are : " + nickname.toString());

				List<String> friends = pd.getFriends();
				System.out.println("Friends name are: " + friends.toString());

				Set<Long> contactNo = pd.getContactNo();
				System.out.println("Contact number are :" + contactNo.toString());

				Map<String, Long> idDetails = pd.getIdDetails();
				System.out.println("Id details are :" + idDetails);
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		// catch
	}// main
}// class
