package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long c_no;
	private String status;
	private long Aadhar_no;

	@ManyToOne
	@JoinColumn
	private BankManager bankManager;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getC_no() {
		return c_no;
	}

	public void setC_no(long c_no) {
		this.c_no = c_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getAadhar_no() {
		return Aadhar_no;
	}

	public void setAadhar_no(long aadhar_no) {
		Aadhar_no = aadhar_no;
	}

	public BankManager getBankManager() {
		return bankManager;
	}

	public void setBankManager(BankManager bankManager) {
		this.bankManager = bankManager;
	}

}
