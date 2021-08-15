package com.BankCrudServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.Bank_appModel.Account;
import com.Bank_appModel.Customer;
import com.Bank_appModel.Employee;
import com.Bank_appModel.Transaction;

import com.bank.service.BankCrudService;
import com.bank_app.dao.Impl.BankDAOImpl;
import com.bank_app.exception.BusinessException;
import com.bankapp.DAO.BankDAO;


public class BankCrudServiceImpl implements BankCrudService
{
	private BankDAO bankDAO=new BankDAOImpl();
	@Override
	public Customer registerAccount(Customer customer) throws BusinessException {
		
		if(customer!=null) {
			System.out.println("checkpoint2");
			customer =bankDAO.registerAccount(customer);
			}
		else 
			{
				throw new BusinessException("not registered");
			}
		
		
		return customer;
	}


	@Override
	public Account createAccount(Account account) throws BusinessException {
		if(account!=null) {
			account=bankDAO.createAccount(account);
		}else {
			throw new BusinessException("Account Not Opened");
		}
		return account;
	}

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> custList=new ArrayList<>();

		if(custList!=null) {
			custList=bankDAO.getAllCustomers();
		}
		return custList;
		
		
	}

	

	
	@Override
	public Customer getPasswordByUserId(String cust_id) throws BusinessException {
		Customer customer=null;
		if(cust_id==null) {
			throw new BusinessException("enter correct Userid");
		}else {
			customer=bankDAO.getPasswordByUserId(cust_id);
		}
		return customer;
	}





	@Override
	public Account getBalanceByAccountNumber(String cust_acc_no) throws BusinessException {
		Account account=null;
		if(cust_acc_no==null)
		{
			throw new BusinessException("enter correct account number");
		}
		else
		{
			account=bankDAO.getBalanceByAccountNumber(cust_acc_no);
		}
		return account;
	}


	@Override
	public Transaction depositAmount(Transaction transaction) throws BusinessException {
		try{
			transaction=bankDAO.depositAmount(transaction);
		}
		catch(BusinessException b) {
			throw new BusinessException("NO TRANSACTION PERFORMED");
		}
		
		return transaction;
	}


	@Override
	public Transaction withdrawAmount(Transaction transaction) throws BusinessException {
		try {
			transaction=bankDAO.withdrawAmount(transaction);	
		}
       catch(BusinessException b) {
			throw new BusinessException("NO TRANSACTION PERFORMED");
		}
		return transaction;
}


	@Override
	public  List<Transaction> getAllTransactions(String cust_acc_no) throws BusinessException {
		
			List<Transaction> statement=new ArrayList<>();
	        if(cust_acc_no!=null ) {
				statement=bankDAO.getAllTransactions(cust_acc_no);
				
			}else {
				throw new BusinessException("Invalid Account Number "+cust_acc_no);
			}
			
			return statement;
		}


	@Override
	public Employee getPasswordByempId(String empId) throws BusinessException {
		Employee employee=null;
		if(empId==null) {
			throw new BusinessException("enter correct Userid");
		}else {
			employee=bankDAO.getPasswordByempId(empId);
		}
		return employee;
	}


	@Override
	public List<Account> getAllAccounts() throws BusinessException {
		List<Account> listAccount=new ArrayList<>();
		try {
			listAccount=bankDAO.getAllAccounts();	
		}
       catch(BusinessException b) {
			throw new BusinessException("No Data EXISTS as of Now");
		}
		return listAccount;
	}


	@Override
	public boolean isValidLoginCredentials(Customer customer) throws BusinessException {
		boolean b=false;
		if(customer!=null ) {
			
			//code here for DAO
			b=bankDAO.isValidLoginCredentials(customer);
		}else {
			throw new BusinessException("Invalid customername or Password");
		}
		
		return b;
	}
	}


	
	


	



	
	