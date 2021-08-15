package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BankCrudServiceImpl.BankCrudServiceImpl;
import com.bank.service.BankCrudService;
import com.bank_app.dao.Impl.BankDAOImpl;
import com.bank_app.exception.BusinessException;
import com.bankapp.DAO.BankDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class AllTransactions
 */
public class AllTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankCrudService bankSearchService = new BankCrudServiceImpl();
	private BankDAO bankDao = new BankDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		String q = request.getParameter("filter");
		PrintWriter out=response.getWriter();
		try {
			out.print(gson.toJson(bankDao.getAllTransactions1()));
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

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
