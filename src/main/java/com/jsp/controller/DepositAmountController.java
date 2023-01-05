package com.jsp.controller;

import com.jsp.service.CustomerService;

public class DepositAmountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//enter customer id, bank account id and amount
		customerService.depositAmount(1, 1, 1000);
	}
}
