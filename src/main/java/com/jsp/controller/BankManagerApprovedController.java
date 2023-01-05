package com.jsp.controller;

import com.jsp.service.AdminService;

public class BankManagerApprovedController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		
		//enter admin id to approve all bank managers
		adminService.approvedAllBankManager(1);
		
		//enter bank manager id and admin id to approve  particular bank manager
//		adminService.approvedBankManager(2,1);
	}
}
