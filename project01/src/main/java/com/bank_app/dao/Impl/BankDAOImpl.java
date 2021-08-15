package com.bank_app.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.Bank_appModel.Account;
import com.Bank_appModel.Customer;
import com.Bank_appModel.Employee;
import com.Bank_appModel.Transaction;

import com.bank_app.dbutil.PostgresConnection;
import com.bank_app.exception.BusinessException;
import com.bankapp.DAO.BankDAO;


public class BankDAOImpl implements BankDAO {

	

	private static Logger log = Logger.getLogger(BankDAOImpl.class);

	@Override
	public Customer registerAccount(Customer customer) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			System.out.println("checkpoint1A");
			String sql = ("insert into bank_schema.customer(cust_id,cust_name,cust_gender,cust_emailId,cust_phno,cust_pwd) values(?,?,?,?,?,?)");
			System.out.println("checkpoint1B");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCust_id());
			
			preparedStatement.setString(2, customer.getCust_name());
			
			
			preparedStatement.setString(3, customer.getCust_gender());
			preparedStatement.setString(4, customer.getCust_emailId());
			preparedStatement.setString(5, customer.getCust_phno());
			preparedStatement.setString(6, customer.getCust_pwd());
		
			int c = preparedStatement.executeUpdate();
			System.out.println("checkpoint1C");
			if (c == 1 ) {
				log.info("Registration Successful");
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return customer;
	}

	@Override
	public Account createAccount(Account account) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql="insert into bank_schema.account(cust_id,cust_acc_no,acc_type,aadhar,open_bal) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getCust_id());
			preparedStatement.setString(2, account.getCust_acc_no());
			preparedStatement.setString(3, account.getAcc_type());
			preparedStatement.setString(4, account.getAadhar());
			preparedStatement.setDouble(5, account.getOpen_bal());
			int c = preparedStatement.executeUpdate();
			
			if (c == 1 ) {
				log.info("Account Opened Successfully");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return account;
		}
	

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		
	List<Customer> custList=new ArrayList<>();
		
		try (Connection connection = PostgresConnection.getConnection()) {
			System.out.println("hi");
			String sql="select * from bank_schema.customer ";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				
				Customer customer=new Customer();
				customer.setCust_id(resultSet.getString("cust_id"));
				customer.setCust_name(resultSet.getString("cust_name"));
				customer.setCust_gender(resultSet.getString("cust_gender"));
				customer.setCust_emailId(resultSet.getString("cust_emailid"));
				customer.setCust_phno(resultSet.getString("cust_phno"));
				customer.setCust_pwd(resultSet.getString("cust_pwd"));
				custList.add(customer);
			}
			if(custList.size()==0) {
				throw new BusinessException("No customer exist");
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);//logger
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return custList;
		
	}
		
		

	
	@Override
	public Customer getByAccountNumber(String cust_acc_no) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getPasswordByUserId(String cust_id) throws BusinessException {
		Customer customer=new Customer();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql="select cust_id,cust_pwd from bank_schema.customer where cust_id=?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, cust_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if (resultSet.next() ) { 
				customer.setCust_id(resultSet.getString("cust_id"));
				customer.setCust_pwd(resultSet.getString("cust_pwd"));
			}else {
				throw new BusinessException("Invalid UserId or Password ");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return customer;
	}
			
	
	


	@Override
	public Account getBalanceByAccountNumber(String cust_acc_no) throws BusinessException {
		Account account = new Account();
		try (Connection connection = PostgresConnection.getConnection()) {

			String sql = "select cust_acc_no,open_Bal from bank_schema.account where cust_acc_no=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cust_acc_no);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				account.setCust_acc_no(resultSet.getString("cust_acc_no"));
				account.setOpen_bal(resultSet.getDouble("open_bal"));
				
			} else {
				throw new BusinessException("Invalid Account Number ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return account;

	}
	
	public Transaction getBalFromTranstable(String cust_acc_no) throws BusinessException{
		Transaction transaction=new Transaction();
		
		
		
		try (Connection connection = PostgresConnection.getConnection()) {

			String sql = "select updatedbalance from bank_schema.transaction where cust_acc_no=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cust_acc_no);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
	
				transaction.setClosingBalance(resultSet.getInt("updatedbalance"));
				
			} else {
				throw new BusinessException("Invalid Account Number ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return transaction ;
	}

	@Override
	public List<Account> getAllAccounts() throws BusinessException {
		List<Account> listAccount=new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select * from bank_schema.account ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Account account=new Account();
				account.setCust_acc_no(resultSet.getString(2));
				account.setAadhar(resultSet.getString(4));
				account.setOpen_bal(resultSet.getDouble(5));
				account.setAcc_type(resultSet.getString(3));
				account.setCust_id(resultSet.getString(1));
				listAccount.add(account);
			}
			if(listAccount.size()==0) {
				throw new BusinessException("No accounts Found in DataBase");
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);//logger
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return listAccount;
	}

	@Override
	public Transaction depositAmount(Transaction transaction) throws BusinessException {
		
		try(Connection connection=PostgresConnection.getConnection())
		{
			String sql="insert into bank_schema.transaction(transType,balance,tamount,updatedbalance,cust_acc_no) values(?,?,?,?,?)";
			String sql1="update bank_schema.account set open_bal=? where cust_acc_no=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
			preparedStatement.setString(1,transaction.getTransType());
			preparedStatement.setDouble(2,transaction.getOpen_bal1());
			preparedStatement.setDouble(3,transaction.getAmount());
			preparedStatement.setDouble(4,transaction.getClosingBalance());
			preparedStatement.setString(5,transaction.getCust_acc_no());
			preparedStatement1.setDouble(1,transaction.getClosingBalance());
			preparedStatement1.setString(2,transaction.getCust_acc_no());
			 
			int c=preparedStatement.executeUpdate();
			int c1=preparedStatement1.executeUpdate();
			
			if(c==1 && c1==1)
			{
				ResultSet resultSet=preparedStatement.getGeneratedKeys();
				if(resultSet.next())
				{
					transaction.setTransId(resultSet.getInt(1));
				}
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
				return transaction;
	}



	@Override
	public Transaction withdrawAmount(Transaction transaction) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into bank_schema.transaction(transtype,balance,tamount,updatedbalance,accountnumber) values(?,?,?,?,?)";
			String sql1 = "update bank_schema.account set balance=? where accountnumber = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement.setString(1, transaction.getTransType());
			preparedStatement.setDouble(2, transaction.getOpen_bal1());
			preparedStatement.setDouble(3, transaction.getAmount());
			preparedStatement.setDouble(4, transaction.getClosingBalance());
			preparedStatement.setString(5, transaction.getCust_acc_no());
			preparedStatement1.setDouble(1, transaction.getClosingBalance());
			preparedStatement1.setString(2, transaction.getCust_acc_no());

			int c = preparedStatement.executeUpdate();
			int c1 = preparedStatement1.executeUpdate();

			if (c == 1 && c1 == 1) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					transaction.setTransId(resultSet.getInt(1));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return transaction;
	}
	
	@Override
	public Transaction transferAmount(Transaction transaction) throws BusinessException {
		
		return transaction;
	}

	@Override
	public List<Transaction> getAllTransactions(String cust_acc_no) throws BusinessException {
	
			List<Transaction> statement=new ArrayList<>();
			try(Connection connection=PostgresConnection.getConnection()){
				String sql="select * from bank_schema.transaction where cust_acc_no = ?";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1, cust_acc_no);
				ResultSet resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Transaction transaction=new Transaction();
					transaction.setTransId(resultSet.getInt("transid"));
					transaction.setTransType(resultSet.getString("transtype"));
					transaction.setCust_acc_no(resultSet.getString("cust_acc_no"));
					transaction.setAmount(resultSet.getDouble("tamount"));
					transaction.setOpen_bal1(resultSet.getDouble("balance"));
					transaction.setClosingBalance(resultSet.getDouble("updatedbalance"));
					transaction.setDate(resultSet.getString("date"));
					statement.add(transaction);
				}
				if(statement.size()==0) {
					throw new BusinessException("No records exists as of now with the AccountNumber  : "+cust_acc_no);
				}
			}catch (ClassNotFoundException | SQLException e) {
				log.error(e);//logger
				throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
			}
			
			
			return statement;
		}

	@Override
	public Employee getPasswordByempId(String emp_id) throws BusinessException {
		Employee employee = new Employee();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select emp_id,emp_pwd from bank_schema.employee where emp_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, emp_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				employee.setEmp_id(resultSet.getString("emp_id"));
				employee.setEmp_pwd(resultSet.getString("emp_pwd"));
			} else {
				throw new BusinessException("Invalid UserId or Password ");
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return employee;
	}

	@Override
	public boolean isValidLoginCredentials(Customer customer) throws BusinessException {
		boolean b=false;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select cust_id from bank_schema.customer where cust_id=? and cust_pwd=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCust_id());
			preparedStatement.setString(2, customer.getCust_pwd());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				b=true;
			}else {
				throw new BusinessException("Invaid Login Credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//logger
			throw new BusinessException("Internal error occured.. Contact SYSADMIN!!!!!!!!!!!!!!!!!");
		}
		return b;
	}
	}
	
	


