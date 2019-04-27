package com.chitiapp.repository;

import com.chitiapp.model.ChitiDetails;
import com.chitiapp.model.MemberDetails;

public interface ChitiRepository {
ChitiDetails save(ChitiDetails cd);
ChitiDetails getChitiDetails(String name);
MemberDetails getChitiMembers(String name);
ChitiDetails getChitiMentainedByUser(String name);




}
