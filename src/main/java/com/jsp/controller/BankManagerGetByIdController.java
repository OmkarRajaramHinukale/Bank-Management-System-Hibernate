package com.jsp.controller;

import com.jsp.service.BankManagerService;

public class BankManagerGetByIdController {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		bankManagerService.getBankManagerById(1);
	}
}
