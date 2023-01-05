package com.jsp.controller;

import com.jsp.service.CustomerService;

public class TransferAmountController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		//enter cust id,debitorid,depositorid,amount
		customerService.transferAmount(2, 1, 2, 300);
	}	
}
