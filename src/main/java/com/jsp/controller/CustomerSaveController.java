package com.jsp.controller;

import com.jsp.dto.Customer;
import com.jsp.service.CustomerService;

public class CustomerSaveController {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		Customer customer=new Customer();
		customer.setName("Rushi");
		customer.setC_no(8759654666l);
		customer.setEmail("rushi65@gmail.com");
		customer.setAadhar_no(919864489898l);
		
		customerService.saveCustomer(customer);
	}
}
