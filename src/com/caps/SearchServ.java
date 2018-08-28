package com.caps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchServ")
public class SearchServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("key");
		System.out.println("Got the keyword: "+keyword);
		System.out.println("Redirecting to Google Search");
		String url = "https://www.google.com/search?q="+keyword;
		resp.sendRedirect(url);
		
	}
}
