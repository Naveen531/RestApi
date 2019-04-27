package com.chitiapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chittimembers")
public class MemberDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@NotBlank
	String number;
	@NotBlank
	String name;
	String email;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chitidetails_id",nullable = false)
	private ChitiDetails chitidetails;

	public MemberDetails() {

	}



	public MemberDetails(@NotNull String number, @NotBlank String name, String email, ChitiDetails chitidetails) {
		super();
		this.number = number;
		this.name = name;
		this.email = email;
		this.chitidetails = chitidetails;
	}



	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public ChitiDetails getchitidetails() {
		return chitidetails;
	}

	public void setchitidetails(ChitiDetails chitidetails) {
		this.chitidetails = chitidetails;
	}

	@Override
	public String toString() {
		return "MemberDetails [id=" + id + ", number=" + number + ", name=" + name + ", email="
				+ email + ", chitidetails=" + chitidetails + "]";
	}

}
