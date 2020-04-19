package com.amsidh.hibernate.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*UserDetails userDetails=new UserDetails();
		userDetails.setUserId(5);
		userDetails.setUserName("USERNAME 4");
		
		Example example=Example.create(userDetails);
		*/
		
		/*UserDetails userDetails=new UserDetails();
		userDetails.setUserId(5);
		
		Example example=Example.create(userDetails);*/
		
		/*UserDetails userDetails=new UserDetails();
		//userDetails.setUserId(5);
		userDetails.setUserName("USERNAME 4");
		Example example=Example.create(userDetails);
		
		Criteria criteria=session.createCriteria(UserDetails.class)
				.add(example);
        */
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("USERNAME%");
		Example example=Example.create(userDetails).enableLike();
		
		Criteria criteria=session.createCriteria(UserDetails.class)
				.add(example);
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}

		session.getTransaction().commit();
		session.close();

	}

}
