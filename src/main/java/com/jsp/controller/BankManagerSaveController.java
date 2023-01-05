package com.jsp.controller;

import com.jsp.dto.BankManager;
import com.jsp.service.BankManagerService;

public class BankManagerSaveController {
	public static void main(String[] args) {
		BankManager bankManager=new BankManager();
		bankManager.setName("Sushant");
		bankManager.setC_no(9798654548l);
		bankManager.setEmail("sushant@gmail.com");
		
		BankManagerService bankManagerService=new BankManagerService();
		BankManager bankManager2=bankManagerService.saveBankManager(bankManager);
		if (bankManager2!=null) {
			System.out.println("Bank manager saved succesfully");
		}else {
			System.out.println("not saved");
		}
	}
}
