package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Admin;
import com.jsp.dto.BankManager;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Omkar");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// to save admin
	public Admin saveAdmin(Admin admin) {
		if (admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
		}
		return admin;
	}

	// to update admin name

	public Admin updateAdminName(int id, String name) {
		Admin admin = entityManager.find(Admin.class, id);
		admin.setName(name);

		if (admin != null) {
			entityTransaction.begin();
			entityManager.merge(admin);
			entityTransaction.commit();

			System.out.println("name updated successfully");
		}
		return admin;
	}

	// to update admin email;

	public Admin updateAdminEmail(int id, String email) {
		Admin admin = entityManager.find(Admin.class, id);
		admin.setEmail(email);

		if (admin != null) {
			entityTransaction.begin();
			entityManager.merge(admin);
			entityTransaction.commit();

			System.out.println("email updated successfully");
		}
		return admin;
	}
	
	//to update admin contact number
	
	public Admin updateAdminCno(int id,long c_no) {
		Admin admin=entityManager.find(Admin.class, id);
		admin.setC_no(c_no);
		
		if (admin!=null) {
			entityTransaction.begin();
			entityManager.merge(admin);
			entityTransaction.commit();

			System.out.println("contact number updated successfully");
		}
		return admin;
	}
	
	// to delete admin
	
	public void deleteAdmin(int id) {
		Admin admin=entityManager.find(Admin.class, id);
		if (admin!=null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			System.out.println("Admin with above id deleted");
		}else {
			System.out.println("no such id found");
		}
	}
	
	//to get admin by id
	
	public Admin getById(int id) {
		Admin admin=entityManager.find(Admin.class, id);
		if (admin!=null) {
			System.out.println("=====================");
			System.out.println("Id: "+admin.getId());
			System.out.println("Name: "+admin.getName());
			System.out.println("Email: "+admin.getEmail());
			System.out.println("Contact Number: "+admin.getC_no());
		}else {
			System.out.println("Object not found");
		}
		return admin;
	}
	
	//to get all admin
	
	public List<Admin> getAllAdmin(){
		String sql="Select a from Admin a";
		Query query=entityManager.createQuery(sql);
		List<Admin> admins=query.getResultList();
		
		for(Admin a:admins) {
			System.out.println("=====================");
			System.out.println("Id: "+a.getId());
			System.out.println("Name: "+a.getName());
			System.out.println("Email: "+a.getEmail());
			System.out.println("Contact Number: "+a.getC_no());
		}
		
		return admins;
	}
	
	//approved all managers
	
	public List<BankManager> approvedAllBankManager(int adminId){
		String sql="Select b from BankManager b";
		Query query=entityManager.createQuery(sql);
		List<BankManager> bankManagers=query.getResultList();
		
		Admin admin=entityManager.find(Admin.class, adminId);
		if (admin!=null) {
			for(BankManager m:bankManagers) {
				if (m.getStatus().equals("Unapproved")) {
					m.setStatus("Approved");
					m.setAdmin(admin);
					
					entityTransaction.begin();
					entityManager.merge(m);
					entityTransaction.commit();
				}
			}
		}else {
			System.out.println("Admin not exists");
		}
		return bankManagers;
	}
	
	//approved particular manager
	
	public BankManager approvedBankManager(int bankManagerId,int adminId) {
		BankManager bankManager=entityManager.find(BankManager.class, bankManagerId);
		Admin admin=entityManager.find(Admin.class, adminId);
		if (admin!=null) {
			if (bankManager.getStatus().equals("Unapproved")) {
				bankManager.setStatus("Approved");
				bankManager.setAdmin(admin);
				entityTransaction.begin();
				entityManager.merge(bankManager);
				entityTransaction.commit();
				System.out.println("Approved Succesfully");
			}else {
				System.out.println("Bank Manager already Approved");
			}
		}else {
			System.out.println("Admin not exist");
		}
		return bankManager;
	}
}
