package com.jsp.controller;

import com.jsp.service.CustomerService;

public class BankAccountDeleteController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//enter bank account id
		customerService.deleteBankAccount(1);
	}
}
