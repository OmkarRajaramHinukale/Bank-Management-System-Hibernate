package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminUpdateController {

	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		
		//to update name
		adminService.updateAdminName(2, "Ajay");
		
		//to update email
		adminService.updateAdminEmail(2, "ajay@gmail.com");
		
		//to update contact number
		adminService.updateAdminCno(2, 7057653289l);

	}

}
