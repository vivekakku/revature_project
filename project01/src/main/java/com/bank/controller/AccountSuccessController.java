package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountSuccessController
 */
public class AccountSuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSuccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if(session == null)
		{
			out.print("<center><h1>Please Login First</h1></center>");
			
			out.print("<h4><a href='/project01'>Click here to Login </a> ");
		}else {
			//out.print("<h1>account creation failed </h1>");
			out.print("<center><h2>Your Account Number is:"+session.getAttribute("cust_acc_no")+"</h2></center>");
			//out.print("<center><h2>Your Account Number is:"+a+"</h2></center>");
			out.print("<p><a href='/project01/index.html'>Click Here to go to MainMenu</a></p>");
			
		}
	}

}
