package com.jsp.service;

import java.util.List;

import com.jsp.dao.BankManagerDao;
import com.jsp.dto.BankManager;
import com.jsp.dto.Customer;

public class BankManagerService {
	BankManagerDao bankManagerDao=new BankManagerDao();
	
	public BankManager saveBankManager(BankManager bankManager) {
		return bankManagerDao.saveBankManager(bankManager);
	}
	
	public BankManager deleteBankManager(int id) {
		return bankManagerDao.deleteBankManager(id);
	}
	
	public BankManager updateBankManagerName(int id,String name) {
		return bankManagerDao.updateBankManagerName(id, name);
	}
	
	public BankManager updateBankManagerEmail(int id,String email) {
		return bankManagerDao.updateBankManagerEmail(id, email);
	}
	
	public BankManager updateBankManagerCno(int id,long c_no) {
		return bankManagerDao.updateBankManagerCno(id, c_no);
	}
	
	public BankManager getBankManagerById(int id) {
		return bankManagerDao.getBankManagerById(id);
	}
	
	public List<BankManager> getAllBankManagers(){
		return bankManagerDao.getAllBankManagers();
	}
	
	public List<Customer> approvedCustomers(int bankManagerId){
		return bankManagerDao.approvedCustomers(bankManagerId);
	}
	
	public Customer approvedCustomer(int cutomerId,int bankManagerId) {
		return bankManagerDao.approvedCustomer(cutomerId, bankManagerId);
	}
	
	
}
