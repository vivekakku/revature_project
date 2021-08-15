package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.BankCrudServiceImpl.BankCrudServiceImpl;
import com.Bank_appModel.Customer;

import com.bank.service.BankCrudService;

import com.bank_app.exception.BusinessException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Servlet implementation class BankCrudController
 */
public class BankCrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static Logger log = Logger.getLogger(BankCrudController.class);
	   private BankCrudService bankCrudService=new BankCrudServiceImpl();
    public BankCrudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		try {
			out.print(gson.toJson(bankCrudService.getAllCustomers()));
		} catch (BusinessException e) {
			
			log.info(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello bro");
		RequestDispatcher requestDispatcher1=null;
		try {
			Gson gson=new Gson();
			Customer customer=gson.fromJson(request.getReader(), Customer.class);
			
			customer=bankCrudService.registerAccount(customer);
			PrintWriter out=response.getWriter();
			
			if(customer!=null) {
				System.out.println("hii");

			response.sendRedirect("Register1.html");
			
			}

				
			log.info(customer);
		} catch (BusinessException e) {
			System.out.println(e);
			System.out.println("in catch 1");
			PrintWriter out=response.getWriter();
			requestDispatcher1=request.getRequestDispatcher("welcome.html");
			requestDispatcher1.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}catch(IllegalStateException | JsonSyntaxException e)
		{
			System.out.println("in catch");
			
		}
		

		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//out.print(gson.toJson(customer));
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
