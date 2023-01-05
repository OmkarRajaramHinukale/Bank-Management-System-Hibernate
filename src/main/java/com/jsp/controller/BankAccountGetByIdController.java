package com.jsp.controller;

import com.jsp.service.CustomerService;

public class BankAccountGetByIdController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//enter bank account id
		customerService.getBankAccountById(2);
	}
}
