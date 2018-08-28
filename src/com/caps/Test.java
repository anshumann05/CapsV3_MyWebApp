package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test")
public class Test extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//if(login success)
		HttpSession session = req.getSession();
		
		
		PrintWriter out = resp.getWriter();
		out.println(resp.encodeURL(req.getRequestURL()+""));
		String redirectUrl = resp.encodeRedirectURL("./login");
		//resp.sendRedirect(redirectUrl);
	}	
}
 