package com.chitiapp.model;

public class CustomMessage {
String msg;
String user;
public CustomMessage(){
	
}
public CustomMessage(String msg, String user) {
	super();
	this.msg = msg;
	this.user = user;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}



}
