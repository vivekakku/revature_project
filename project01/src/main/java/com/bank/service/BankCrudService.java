package com.bank.service;

import java.util.List;

import com.Bank_appModel.Account;
import com.Bank_appModel.Customer;
import com.Bank_appModel.Employee;
import com.Bank_appModel.Transaction;

import com.bank_app.exception.BusinessException;

public interface BankCrudService {
	
	public Customer registerAccount(Customer customer) throws BusinessException;
	public Account createAccount(Account account) throws BusinessException;
	
	
	public List<Customer> getAllCustomers() throws BusinessException;
	public List<Account> getAllAccounts() throws BusinessException;
	
	public Transaction withdrawAmount(Transaction transaction) throws BusinessException; 

	
	public Transaction depositAmount(Transaction transaction) throws BusinessException;
	
	public Customer getPasswordByUserId(String cust_id) throws BusinessException;              //getting the password with user for equals method
	public Account getBalanceByAccountNumber(String cust_acc_no) throws BusinessException; 
	

	public List<Transaction> getAllTransactions(String cust_acc_no) throws BusinessException;
	
	public Employee getPasswordByempId(String empId) throws BusinessException;
	
	public boolean isValidLoginCredentials(Customer customer) throws BusinessException;

	
}
