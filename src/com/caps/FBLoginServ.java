package com.caps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FBLoginServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("email");
		String passwd = req.getParameter("pass");
		
		resp.getWriter().println("<h1>Data Submitted</h1>");
		System.out.println(user);
		System.out.println(passwd);
	}
}
