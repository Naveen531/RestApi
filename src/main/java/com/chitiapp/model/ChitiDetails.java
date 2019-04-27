package com.chitiapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="chitidetails")
public class ChitiDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank
	private String chitiName;
	@NotNull
	private long amount;
	@NotNull
	private int members;
	@NotNull
	private int months;
	@NotNull
	private Date startDate;
	@NotBlank
	private String ownedby;
	@NotNull
	private Date endDate;
	
	//@OneToMany
	@OneToMany(mappedBy="chitidetails",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MemberDetails> memberDetails;

	public ChitiDetails() {
		
	}




	public ChitiDetails(@NotBlank String chitiName, @NotNull long amount, @NotNull int members, @NotNull int months,
			@NotNull Date startDate, @NotBlank String ownedby, @NotNull Date endDate,
			List<MemberDetails> memberDetails) {
		super();
		this.chitiName = chitiName;
		this.amount = amount;
		this.members = members;
		this.months = months;
		this.startDate = startDate;
		this.ownedby = ownedby;
		this.endDate = endDate;
		this.memberDetails = memberDetails;
	}




	public String getOwnedby() {
		return ownedby;
	}



	public void setOwnedby(String ownedby) {
		this.ownedby = ownedby;
	}



	public String getChitiName() {
		return chitiName;
	}

	public void setChitiName(String chitiName) {
		this.chitiName = chitiName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	public List<MemberDetails> getMemberDetails() {
		return memberDetails;
	}



	public void setMemberDetails(List<MemberDetails> memberDetails) {
		//memberDetails.get(0).setchitidetails(this);
		this.memberDetails = memberDetails;
	}



	@Override
	public String toString() {
		return "ChitiDetails [ chitiName=" + chitiName + ", amount=" + amount + ", members=" + members
				+ ", months=" + months + ", startDate=" + startDate + ", ownedby=" + ownedby + ", endDate=" + endDate
				+ ", memberDetails=" + memberDetails + "]";
	}




	
	

}
