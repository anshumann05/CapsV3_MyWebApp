package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomNumGeneratorServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String randomNum = UUID.randomUUID().toString();
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>The Randon Number is: "+randomNum + "</h1>");
	}
}
