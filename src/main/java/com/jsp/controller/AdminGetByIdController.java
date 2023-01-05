package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminGetByIdController {

	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		adminService.getById(1);

	}

}
