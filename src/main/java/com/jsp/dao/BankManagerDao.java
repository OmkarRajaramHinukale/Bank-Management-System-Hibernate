package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankManager;
import com.jsp.dto.Customer;

public class BankManagerDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkar");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	//Save Bank Manager
	public BankManager saveBankManager(BankManager bankManager) {
		bankManager.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(bankManager);
		entityTransaction.commit();
		return bankManager;
	}
	
	//to delete bankManager
	public BankManager deleteBankManager(int id) {
		BankManager bankManager=entityManager.find(BankManager.class, id);
		if (bankManager!=null) {
			entityTransaction.begin();
			entityManager.remove(bankManager);
			entityTransaction.commit();
			System.out.println("Bank Manager deleted successfully");
		}else {
			System.out.println("Bank Manager not exists");
		}
		return bankManager;
	}
	
	//update bank manager name
	public BankManager updateBankManagerName(int id,String name) {
		BankManager bankManager=entityManager.find(BankManager.class, id);
		bankManager.setName(name);
		
		if (bankManager!=null) {
			entityTransaction.begin();
			entityManager.merge(bankManager);
			entityTransaction.commit();
			System.out.println("updated succesfully");
		}
		return bankManager;
	}
	
	//update bank manager email
	public BankManager updateBankManagerEmail(int id,String email) {
		BankManager bankManager=entityManager.find(BankManager.class, id);
		bankManager.setEmail(email);
		
		if (bankManager!=null) {
			entityTransaction.begin();
			entityManager.merge(bankManager);
			entityTransaction.commit();
			System.out.println("updated succesfully");
		}
		return bankManager;
	}
	
	//update bank  manager contact number
	public BankManager updateBankManagerCno(int id,long c_no) {
		BankManager bankManager=entityManager.find(BankManager.class, id);
		bankManager.setC_no(c_no);
		
		if (bankManager!=null) {
			entityTransaction.begin();
			entityManager.merge(bankManager);
			entityTransaction.commit();
			System.out.println("updated succesfully");
		}
		return bankManager;
	}
	
	//to get bank manager details by id
	
	public BankManager getBankManagerById(int id) {
		BankManager bankManager=entityManager.find(BankManager.class, id);
		if (bankManager!=null) {
			System.out.println("Id: "+bankManager.getId());
			System.out.println("Name: "+bankManager.getName());
			System.out.println("Email: "+bankManager.getEmail());
			System.out.println("Contact number: "+bankManager.getC_no());
			System.out.println("Status: "+bankManager.getStatus());
		}else {
			System.out.println("details not found");
		}
		return bankManager;
	}
	
	//get all bank manager details
	
	public List<BankManager> getAllBankManagers(){
		String sql="Select b from BankManager b";
		Query query=entityManager.createQuery(sql);
		List<BankManager> bankManagers=query.getResultList();
		
		for(BankManager b:bankManagers) {
			System.out.println("===================");
			System.out.println("Id: "+b.getId());
			System.out.println("Name: "+b.getName());
			System.out.println("Email: "+b.getEmail());
			System.out.println("Contact number: "+b.getC_no());
			System.out.println("Status: "+b.getStatus());
		}
		return bankManagers;
	}
	
	//to approve all customer
	public List<Customer> approvedCustomers(int bankManagerId){
		String sql="Select c from Customer c";
		Query query=entityManager.createQuery(sql);
		List<Customer> customers=query.getResultList();
		
		BankManager bankManager=entityManager.find(BankManager.class, bankManagerId);
		if (bankManager.getStatus().equals("Approved")) {
			for (Customer c : customers) {
				if (c.getStatus().equals("Unapproved")) {
					c.setStatus("Approved");
					c.setBankManager(bankManager);
					entityTransaction.begin();
					entityManager.merge(c);
					entityTransaction.commit();
				}
			}
		}else {
			System.out.println("Bank Manager is not approved");
		}
		return customers;
	}
	
	//approve particular customer
	public Customer approvedCustomer(int cutomerId,int bankManagerId) {
		Customer customer=entityManager.find(Customer.class, cutomerId);
		BankManager bankManager=entityManager.find(BankManager.class, bankManagerId);
		if (bankManager.getStatus().equals("Approved")) {
			if (customer.getStatus().equals("Unapproved")) {
				customer.setStatus("Approved");
				customer.setBankManager(bankManager);
				entityTransaction.begin();
				entityManager.merge(customer);
				entityTransaction.commit();
				System.out.println("Approved Successfully");
			}else {
				System.out.println("Customer already approved");
			}
		}else {
			System.out.println("Bank manager is not approved");
		}
		return customer;
	}
}
