package com.jsp.controller;

import com.jsp.service.CustomerService;

public class CustomerUpdateController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		
		customerService.updateCustomerName(2, "Vishal");
		
		customerService.updateCustomerEmail(2, "vishal78@gmail.com");
		
		customerService.updateCustomerCno(2, 7895632512l);
	}
}
