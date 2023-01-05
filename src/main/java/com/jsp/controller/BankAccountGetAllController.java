package com.jsp.controller;

import com.jsp.service.CustomerService;

public class BankAccountGetAllController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		customerService.getAllBankAccount();
	}
}
