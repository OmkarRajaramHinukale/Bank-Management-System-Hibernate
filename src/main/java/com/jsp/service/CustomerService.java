package com.jsp.service;

import java.util.List;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.BankAccount;
import com.jsp.dto.BankStatement;
import com.jsp.dto.Customer;

public class CustomerService {
	CustomerDao customerDao=new CustomerDao();
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	public Customer deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}
	
	public Customer updateCustomerName(int id, String name) {
		return customerDao.updateCustomerName(id, name);
	}
	
	public Customer updateCustomerEmail(int id, String email) {
		return customerDao.updateCustomerEmail(id, email);
	}
	
	public Customer updateCustomerCno(int id, long c_no) {
		return customerDao.updateCustomerCno(id, c_no);
	}
	
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}
	
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}
	
	public BankAccount saveBankAccount(BankAccount bankAccount, int customerId) {
		return customerDao.saveBankAccount(bankAccount, customerId);
	}
	
	public BankAccount deleteBankAccount(int id) {
		return customerDao.deleteBankAccount(id);
	}
	
	public BankAccount getBankAccountById(int id) {
		return customerDao.getBankAccountById(id);
	}
	
	public List<BankAccount> getAllBankAccount() {
		return customerDao.getAllBankAccount();
	}
	
	public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.depositAmount(customerId, bankAccountId, amount);
	}
	
	public BankAccount debitAmount(int customerId,int bankAccountId,double amount) {
		return customerDao.debitAmount(customerId, bankAccountId, amount);
	}
	
	public BankAccount transferAmount(int cutomerId,int debitorId,int creditorId,double amount) {
		return customerDao.transferAmount(cutomerId, debitorId, creditorId, amount);
	}
	
	public List<BankStatement> bankAccountStatement(int bankAccountId){
		return customerDao.bankAccountStatement(bankAccountId);
	}
}
