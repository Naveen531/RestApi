package com.chitiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.chitiapp.model.ChitiDetails;
import com.chitiapp.model.MemberDetails;
import com.chitiapp.model.Users;
import com.chitiapp.repository.ChitiRepository;
import com.chitiapp.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserRepository ur;
	@Autowired
	ChitiRepository cr;

	@Override

	public Users findUser(String a) {
		// TODO Auto-generated method stub
		return ur.getUserbyEmail(a);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users applicationUser = ur.getUserbyEmail(username);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
	}

	@Override
	public Users save(Users u) {
		// TODO Auto-generated method stub
		return ur.save(u);
	}

	@Override
	public ChitiDetails save(ChitiDetails cd) {
		MemberDetails md = new MemberDetails();
		List<MemberDetails> memList = new ArrayList<MemberDetails>();
		for(MemberDetails memd:cd.getMemberDetails()) {
			md =new MemberDetails();
			md.setName(memd.getName());
			md.setName(memd.getName());
			md.setNumber(memd.getNumber());
			md.setchitidetails(cd);
			memList.add(md);
		}
		cd.setMemberDetails(memList);
		return cr.save(cd);
		// return cd;
		// TODO Auto-generated method stub

	}

	@Override
	public ChitiDetails getChitiDetails(String name) {
		return cr.getChitiDetails(name);
	}

	@Override
	public MemberDetails getChitiMembers(String name) {
		return cr.getChitiMembers(name);
	}

	@Override
	public ChitiDetails getChitiMentainedByUser(String name) {
		// TODO Auto-generated method stub
		return cr.getChitiMentainedByUser(name);
	}

}
