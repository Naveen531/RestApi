package com.chitiapp.model;

public class ChitiOwned {
String chitiName;
String chitiOwner;
String chitiMemberName;
public ChitiOwned(String chitiName, String chitiOwner, String chitiMemberName) {
	super();
	this.chitiName = chitiName;
	this.chitiOwner = chitiOwner;
	this.chitiMemberName = chitiMemberName;
}
public String getChitiName() {
	return chitiName;
}
public void setChitiName(String chitiName) {
	this.chitiName = chitiName;
}
public String getChitiOwner() {
	return chitiOwner;
}
public void setChitiOwner(String chitiOwner) {
	this.chitiOwner = chitiOwner;
}
public String getChitiMemberName() {
	return chitiMemberName;
}
public void setChitiMemberName(String chitiMemberName) {
	this.chitiMemberName = chitiMemberName;
}
@Override
public String toString() {
	return "ChitiOwned [chitiName=" + chitiName + ", chitiOwner=" + chitiOwner + ", chitiMemberName=" + chitiMemberName
			+ "]";
}



}
