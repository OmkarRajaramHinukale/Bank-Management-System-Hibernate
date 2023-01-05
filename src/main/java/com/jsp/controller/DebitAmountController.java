package com.jsp.controller;

import com.jsp.service.CustomerService;

public class DebitAmountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//enter cust id,bank account id,amount
		customerService.debitAmount(2, 1, 200);
	}
}
