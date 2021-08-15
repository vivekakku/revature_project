package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BankCrudServiceImpl.BankCrudServiceImpl;
import com.bank.service.BankCrudService;
import com.bank_app.exception.BusinessException;
import com.google.gson.Gson;

/**
 * Servlet implementation class StatementController
 */
public class StatementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankCrudService bankSearchService = new BankCrudServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson=new Gson();
		Long q = Long.parseLong(request.getParameter("accountnumber"));
		//session.getAttribute("userId");
		PrintWriter out=response.getWriter();
		System.out.println(q);
		
		try {
			System.out.println("in try");
			out.print(gson.toJson(bankSearchService.getAllTransactions(q)));
		} catch (BusinessException e) {
			
			out.print(e.getMessage());
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
