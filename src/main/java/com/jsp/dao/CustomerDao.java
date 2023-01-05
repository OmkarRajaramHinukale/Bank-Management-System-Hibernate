package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankAccount;
import com.jsp.dto.BankStatement;
import com.jsp.dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Omkar");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	BankStatement bankStatement = new BankStatement();

	// to save customer
	public Customer saveCustomer(Customer customer) {
		String sql = "Select c from Customer c";
		Query query = entityManager.createQuery(sql);
		List<Customer> customers = query.getResultList();
		for (Customer c : customers) {
			if (c.getAadhar_no() == customer.getAadhar_no()) {
				System.out.println("Customer already exists");
				return null;
			}
		}
		customer.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		System.out.println("Custommer saved succesfully");
		return customer;
	}

	// to delete customer
	public Customer deleteCustomer(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.remove(customer);
			entityTransaction.commit();
			System.out.println("Customer deleted succesfully");
		} else {
			System.out.println("customer not exist");
		}
		return customer;
	}

	// to update customer name
	public Customer updateCustomerName(int id, String name) {
		Customer customer = entityManager.find(Customer.class, id);
		customer.setName(name);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.merge(customer);
			entityTransaction.commit();
		}
		return customer;
	}

	// to update customer email
	public Customer updateCustomerEmail(int id, String email) {
		Customer customer = entityManager.find(Customer.class, id);
		customer.setEmail(email);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.merge(customer);
			entityTransaction.commit();
		}
		return customer;
	}

	// to update customer contact number
	public Customer updateCustomerCno(int id, long c_no) {
		Customer customer = entityManager.find(Customer.class, id);
		customer.setC_no(c_no);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.merge(customer);
			entityTransaction.commit();
		}
		return customer;
	}

	// to display customer by id
	public Customer getCustomerById(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null) {
			System.out.println("Id: " + customer.getId());
			System.out.println("Name: " + customer.getName());
			System.out.println("Contact number: " + customer.getC_no());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Aadhar card number: " + customer.getAadhar_no());
			System.out.println("Status: " + customer.getStatus());
		} else {
			System.out.println("Customer not exists");
		}
		return customer;
	}

	// to display all customer
	public List<Customer> getAllCustomer() {
		String sql = "Select c from Customer c";
		Query query = entityManager.createQuery(sql);
		List<Customer> customers = query.getResultList();

		for (Customer c : customers) {
			System.out.println("===================");
			System.out.println("Id: " + c.getId());
			System.out.println("Name: " + c.getName());
			System.out.println("Contact number: " + c.getC_no());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Aadhar card number: " + c.getAadhar_no());
			System.out.println("Status: " + c.getStatus());
		}
		return customers;
	}

	// to save bank Account
	public BankAccount saveBankAccount(BankAccount bankAccount, int customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		bankAccount.setCustomer(customer);
		bankAccount.setAccount_no(60224568 + customerId);
		String sql = "Select b from BankAccount b";
		Query query = entityManager.createQuery(sql);
		List<BankAccount> bankAccounts = query.getResultList();
		for (BankAccount b : bankAccounts) {
			if (b.getAccount_no() == bankAccount.getAccount_no()) {
				System.out.println("Bank Account is already exists for this customer");
				return null;
			}
		}
		if (customer.getStatus().equals("Approved")) {
			if (bankAccount.getBalance() > 499) {
				entityTransaction.begin();
				entityManager.persist(bankAccount);
				entityTransaction.commit();
				System.out.println("Bank Account added succesfully");
			} else {
				System.out.println("Minimum 500rs should be deposit for create Bank Account");
			}
		} else {
			System.out.println("Customer is not approved");
		}
		return bankAccount;
	}

	// to delete bank account
	public BankAccount deleteBankAccount(int id) {
		BankAccount bankAccount = entityManager.find(BankAccount.class, id);
		if (bankAccount != null) {
			entityTransaction.begin();
			entityManager.remove(bankAccount);
			entityTransaction.commit();
			System.out.println("Bank Account deleted succesfully");
		} else {
			System.out.println("Bank Account not exists");
		}
		return bankAccount;
	}

	// to get bank account details by id
	public BankAccount getBankAccountById(int id) {
		BankAccount bankAccount = entityManager.find(BankAccount.class, id);
		if (bankAccount != null) {
			System.out.println("Id: " + bankAccount.getId());
			System.out.println("Account Number: " + bankAccount.getAccount_no());
			System.out.println("Ifsc: " + bankAccount.getIfsc());
			System.out.println("Balance: " + bankAccount.getBalance());
		} else {
			System.out.println("Bank account not exists");
		}
		return bankAccount;
	}

	// to get all bank account details
	public List<BankAccount> getAllBankAccount() {
		String sql = "Select b from BankAccount b";
		Query query = entityManager.createQuery(sql);
		List<BankAccount> bankAccounts = query.getResultList();
		for (BankAccount b : bankAccounts) {
			System.out.println("======================");
			System.out.println("Id: " + b.getId());
			System.out.println("Account Number: " + b.getAccount_no());
			System.out.println("Ifsc: " + b.getIfsc());
			System.out.println("Balance: " + b.getBalance());
		}
		return bankAccounts;
	}

	// to deposit amount
	public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
		Customer customer = entityManager.find(Customer.class, customerId);
		BankAccount bankAccount = entityManager.find(BankAccount.class, bankAccountId);
		if (customer.getStatus().equals("Approved")) {
			if (amount > 0) {
				bankAccount.setBalance(bankAccount.getBalance() + amount);
				bankStatement.setBid(bankAccountId);
				bankStatement.setDetails(
						"Deposited: Rs." + amount + " to your account number: " + bankAccount.getAccount_no());
				entityTransaction.begin();
				entityManager.merge(bankAccount);
				entityManager.persist(bankStatement);
				entityTransaction.commit();
				System.out.println("Amount deposited succesfully");
			} else {
				System.out.println("Invalid amount");
			}
		} else {
			System.out.println("Customer is not approved");
		}
		return bankAccount;
	}

	// to debit amount
	public BankAccount debitAmount(int customerId,int bankAccountId,double amount) {
		Customer customer=entityManager.find(Customer.class, customerId);
		BankAccount bankAccount=entityManager.find(BankAccount.class, bankAccountId);
		if (customer.getStatus().equals("Approved")) {
			if (bankAccount.getCustomer().getId()==customerId) {
				if (amount<bankAccount.getBalance() && amount>0) {
					bankAccount.setBalance(bankAccount.getBalance()-amount);
					bankStatement.setBid(bankAccountId);
					bankStatement.setDetails("Debited: Rs. "+amount+" from your account number: "+bankAccount.getAccount_no());
					entityTransaction.begin();
					entityManager.merge(bankAccount);
					entityManager.persist(bankStatement);
					entityTransaction.commit();
					System.out.println("Ammount debited succesfully");
				}else {
					System.out.println("Insufficient balance");
				}
			}else {
				System.out.println("This is not your bank Account");
			}
		}else {
			System.out.println("Customer is not approved");
		}
		return bankAccount;
	}
	
	//To transfer amount
	public BankAccount transferAmount(int cutomerId,int debitorId,int creditorId,double amount) {
		Customer customer=entityManager.find(Customer.class, cutomerId);
		BankAccount bankAccount1=entityManager.find(BankAccount.class, debitorId);
		BankAccount bankAccount2=entityManager.find(BankAccount.class, creditorId);
		if (customer.getStatus().equals("Approved")) {
			if (bankAccount1.getCustomer().getId()==cutomerId) {
				if (amount>0 && bankAccount1.getBalance()>amount) {
					bankAccount1.setBalance(bankAccount1.getBalance()-amount);
					bankStatement.setBid(debitorId);
					bankStatement.setDetails("Debited :Rs. "+amount+" from your account number: "+bankAccount1.getAccount_no());
					
					bankAccount2.setBalance(bankAccount2.getBalance()+amount);
					BankStatement bankStatement2=new BankStatement();
					bankStatement2.setBid(creditorId);
					bankStatement2.setDetails("Credited: Rs."+amount+" by account number: "+bankAccount1.getAccount_no()+"to your account no:"+bankAccount2.getAccount_no());
					entityTransaction.begin();
					entityManager.merge(bankAccount1);
					entityManager.merge(bankAccount2);
					entityManager.persist(bankStatement);
					entityManager.persist(bankStatement2);
					entityTransaction.commit();
					System.out.println("Amount Transferred succesfully");
				}else {
					System.out.println("Insufficient balance");
				}
			}else {
				System.out.println("This is not your bank account");
			}
		}else {
			System.out.println("Customer is not approved");
		}
		return bankAccount1;
	}
	
	//statement of bankAccounts
	public List<BankStatement> bankAccountStatement(int bankAccountId){
		String sql="Select s from BankStatement s";
		Query query=entityManager.createQuery(sql);
		List<BankStatement> bankStatements=query.getResultList();
		System.out.println(" Statement of Bank Account id: "+bankAccountId);
		for (BankStatement b : bankStatements) {
			if (bankAccountId==b.getBid()) {
				System.out.println(b.getDetails());
			}
		}
		return bankStatements;
	}
}
