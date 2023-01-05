package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class BankManagerUpdateController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		
		bankManagerService.updateBankManagerName(2, "Sujit");
		
		bankManagerService.updateBankManagerCno(2, 8965746532l);
		
		bankManagerService.updateBankManagerEmail(2, "sujit@gmail.com");
		
	}
}
