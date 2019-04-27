package com.chitiapp.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chitiapp.model.Users;
@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	SessionFactory sf;

	@Override
	public Users getUserbyEmail(String email) {
		System.out.println("==============:email=======;"+email);
		Query q = sf.getCurrentSession().createQuery(" from Users where email=:email");
		q.setParameter("email", email);
		List<Users> list = q.getResultList();
		System.out.println(list.size()+" "+list.get(0).getEmail());
		System.out.println(list.get(0).toString());
		return list.get(0);
		// int status=q.
	}
	
	public Users save(Users u) {
		
		sf.getCurrentSession().save(u);
		return u;
		
	}
	
	

}
