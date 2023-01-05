package com.jsp.controller;

import com.jsp.service.CustomerService;

public class CustomerDeleteController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		customerService.deleteCustomer(3);
	}
}
