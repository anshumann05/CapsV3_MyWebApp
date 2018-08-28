package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serv1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cat c = new Cat();
		c.setName("Jinnie");
		c.setGender("Female");
		c.setColor("White");
		
		req.setAttribute("cat", c);
		
		PrintWriter out = resp.getWriter();
		out.println("Cat is been set inside req Object");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/serv2");
		dispatcher.include(req, resp);
	}
}
