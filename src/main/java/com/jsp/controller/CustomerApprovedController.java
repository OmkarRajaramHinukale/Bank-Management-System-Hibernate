package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class CustomerApprovedController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		
		//to approve all customers enter bank manager id
		bankManagerService.approvedCustomers(1);
		
		//to approve particular customer enter cust id and bank mgr id
//		bankManagerService.approvedCustomer(2, 2);
	}
}
