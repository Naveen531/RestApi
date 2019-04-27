package com.chitiapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users")
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank
	@Size(max=40)
	String name;
	
	@NaturalId
	@NotBlank
    @Email
	String email;
	
    @NotNull(message = "Please enter id")
	long phonenumber;
	@NotBlank
	
	String password;
	
	@NotBlank
	@Size(max=6)
	String role;
	public Users() {
		
	}
	public Users(String name, String email, long phoneNumber, String password,String role) {
		super();
		this.role=role;
		this.name = name;
		this.email = email;
		this.phonenumber = phoneNumber;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phonenumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
	

}
