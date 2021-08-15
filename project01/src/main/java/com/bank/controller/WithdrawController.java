package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BankCrudServiceImpl.BankCrudServiceImpl;
import com.Bank_appModel.Account;
import com.Bank_appModel.Transaction;
import com.bank.service.BankCrudService;
import com.bank_app.dao.Impl.BankDAOImpl;
import com.bank_app.exception.BusinessException;
import com.bankapp.DAO.BankDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class WithdrawController
 */
public class WithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      BankCrudService bankCrudService=new BankCrudServiceImpl();
      BankDAO bankdao=new BankDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out=response.getWriter();
		RequestDispatcher requestDispatcher=null;
		response.setContentType("text/html");
		if(session == null)
		{
			out.print("<center><h1>Please Login First</h1></center>");
			out.print("<h4><a href='/project01'>Click here to Login </a> ");
		}else {
			out.print("<h1>Welcome "+session.getAttribute("cust_id")+" ..... You have logged in successfully at "+new Date(session.getCreationTime())+"</h1>");
			Gson gson=new Gson();
			Transaction transaction2=new Transaction();
			Transaction transaction =gson.fromJson(request.getReader(), Transaction.class);
			System.out.println(transaction);
			String cust_acc_no=transaction.getCust_acc_no();		
			 try {
				
				transaction2=bankdao.getBalFromTranstable(cust_acc_no);
				System.out.println(transaction2.getClosingBalance());
				double amount=transaction2.getClosingBalance();
				 Account account = bankCrudService.getBalanceByAccountNumber(cust_acc_no);
				 System.out.println(account);
				 System.out.println(transaction.getTamount());
				 double openingBalance = account.getOpen_bal();
				 System.out.println(openingBalance);
				 if(amount<0) {
					 session.setAttribute("accountNumberw", transaction.getCust_acc_no());
					 session.setAttribute("closingBalancew", "Insufficient Funds");
				 }
				 else {
				 Transaction transaction1=new Transaction(cust_acc_no, amount, transaction.getTamount(),amount-(transaction.getTamount()) , "Withdraw");
					transaction = bankCrudService.depositAmount(transaction1);
					session.setAttribute("accountNumberw", transaction1.getCust_acc_no());
					session.setAttribute("closingBalancew", transaction1.getClosingBalance());
					System.out.println(transaction1);
					
				 }
				} catch (BusinessException e) {
					
					requestDispatcher.include(request, response);
					out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
				}
			
				response.setContentType("application/json;charset=UTF-8");
	}

	}
}


