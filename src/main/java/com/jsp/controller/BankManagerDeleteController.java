package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class BankManagerDeleteController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		bankManagerService.deleteBankManager(3);
	}
}
