package com.chitiapp.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chitiapp.model.ChitiDetails;
import com.chitiapp.model.MemberDetails;
@Repository
public class ChitiRepositoryImpl implements ChitiRepository{
	@Autowired
	SessionFactory sf;
	@Override
	public ChitiDetails save(ChitiDetails cd) {
		try {
			sf.getCurrentSession().save(cd);
			return cd;
			
		} catch (Exception e) {
			throw e;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChitiDetails getChitiDetails(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDetails getChitiMembers(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChitiDetails getChitiMentainedByUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
