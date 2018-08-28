package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("regno");
		String password = req.getParameter("passwd");
		
		System.out.println(regno);
		System.out.println(password);
		
		//if login successful
			HttpSession session = req.getSession();
			PrintWriter out = resp.getWriter();
			out.println("Session created");
	}
}
