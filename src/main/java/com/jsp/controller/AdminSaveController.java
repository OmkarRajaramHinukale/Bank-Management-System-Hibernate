package com.jsp.controller;

import com.jsp.dto.Admin;
import com.jsp.service.AdminService;

public class AdminSaveController {

	public static void main(String[] args) {
		Admin admin=new Admin();
		
		admin.setName("Sushant");
		admin.setEmail("sushant@gmail.com");
		admin.setC_no(6598789654l);
		
		AdminService adminService=new AdminService();
		Admin admin2=adminService.saveAdmin(admin);
		if (admin2!=null) {
			System.out.println("Admin saved succesfully");
		}else {
			System.out.println("Admin not saved");
		}
	}

}
