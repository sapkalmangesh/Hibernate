package com.in.ms.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.in.ms.entity.Product;
import com.in.ms.utility.HibernateUtil;

public class Auto_PaginationTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter page size- ");
		int pageSize = sc.nextInt();
		//create SessionFactory Object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//cteate Session Object
		Session ses = HibernateUtil.getSession();
		try(factory;ses){
			Query query = ses.createQuery("select count(*) from Product");
			long totalRecords = (long) query.getSingleResult();
			long pagesCount = totalRecords/pageSize;
			if (totalRecords%pageSize!=0) {
				pagesCount++;

				// create select HQL query
				Query query1 = ses.createQuery("from Product");
				for(int pageNo=1;pageNo<=pagesCount;++pageNo) {
					System.out.println(pageNo+"/"+pagesCount);
					int startPosition = (int) ((pageNo*pageSize)-pageSize);
					//Set Pagination param
					query1.setFirstResult(startPosition);
			   		query1.setMaxResults(pageSize);
					//execute query
					List<Product> list = query1.getResultList();
					list.forEach(System.out::println);
					System.out.println("-----------------------------");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
