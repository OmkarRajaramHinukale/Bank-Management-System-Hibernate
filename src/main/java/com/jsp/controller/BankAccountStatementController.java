package com.jsp.controller;

import com.jsp.service.CustomerService;

public class BankAccountStatementController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//enter bank account id
		customerService.bankAccountStatement(2);
	}
}
