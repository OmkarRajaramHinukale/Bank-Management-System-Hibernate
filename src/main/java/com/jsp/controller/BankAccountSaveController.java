package com.jsp.controller;

import com.jsp.dto.BankAccount;
import com.jsp.service.CustomerService;

public class BankAccountSaveController {
	public static void main(String[] args) {
		BankAccount bankAccount=new BankAccount();
		
		bankAccount.setAccount_no(123565);
		bankAccount.setIfsc("HDFC123");
		bankAccount.setBalance(500);
		
		CustomerService customerService=new CustomerService();
		
		//enter bank account and customer id
		customerService.saveBankAccount(bankAccount, 1);
	}
}
