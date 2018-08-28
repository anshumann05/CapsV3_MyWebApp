package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/date")
public class MyFirstServlet extends HttpServlet {

	public MyFirstServlet() {
		System.out.println("instantiation phase");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("inside inti pahase");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside service pahse");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");

		ServletContext ctx = getServletContext();
		String email = ctx.getInitParameter("email");



		//int i = 10/0;


		PrintWriter out = resp.getWriter();
		out.println("<h1>The Current Time is: "+ new Date() +"</h1>");
		out.println("<h1>Name: "+fname+" "+lname+"</h1>");
		out.println(email);
		
		ServletConfig config = getServletConfig();
		String passwd = config.getInitParameter("password");
		out.println("password: "+passwd);

		resp.setContentType("text/html");
	}

	@Override
	public void destroy() {
		System.out.println("I am dead...bye bye world  :'( ");
	}
}












