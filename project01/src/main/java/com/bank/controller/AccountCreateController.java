package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BankCrudServiceImpl.BankCrudServiceImpl;
import com.Bank_appModel.Account;
import com.bank.service.BankCrudService;
import com.bank_app.exception.BusinessException;
import com.google.gson.Gson;

/**
 * Servlet implementation class AccountCreateController
 */
public class AccountCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	BankCrudService bankCrudService=new BankCrudServiceImpl();
    public AccountCreateController() {
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
			
			Gson gson = new Gson();
			Account account = gson.fromJson(request.getReader(), Account.class);
			System.out.println(account);
			System.out.println("controller check");
			session.setAttribute("cust_id", account.getCust_id());
			session.setAttribute("open_bal", account.getOpen_bal());
			
			try {
				account = bankCrudService.createAccount(account);
				session.setAttribute("cust_acc_no", account.getCust_acc_no());
				response.sendRedirect("accountsuccess");
				
			} catch (BusinessException e) {
				requestDispatcher=request.getRequestDispatcher("openaccount.html");
				requestDispatcher.include(request, response);
				out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
			}
			
		
		
		
		out.print("<a href='logout'>Click Here to LOGOUT</a>");
	}

	}

}
