package com.chitiapp.service;

import com.chitiapp.model.ChitiDetails;
import com.chitiapp.model.MemberDetails;
import com.chitiapp.model.Users;

public interface UserService {
Users findUser(String a);
Users save(Users u);
ChitiDetails save(ChitiDetails cd);
ChitiDetails getChitiDetails(String name);
MemberDetails getChitiMembers(String name);
ChitiDetails getChitiMentainedByUser(String name);
}
