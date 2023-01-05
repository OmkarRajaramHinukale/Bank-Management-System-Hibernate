package com.jsp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long c_no;

	@OneToMany(mappedBy = "admin")
	private List<BankManager> bankManager;

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

	public List<BankManager> getBankManager() {
		return bankManager;
	}

	public void setBankManager(List<BankManager> bankManager) {
		this.bankManager = bankManager;
	}

}
