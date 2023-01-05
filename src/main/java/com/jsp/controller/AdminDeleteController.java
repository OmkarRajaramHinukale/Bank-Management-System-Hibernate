package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminDeleteController {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		adminService.deleteAdmin(4);
	}
}
