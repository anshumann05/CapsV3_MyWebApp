package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieServ")
public class CookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("$name", "Aatish");
		cookie1.setMaxAge(Integer.MAX_VALUE);
		Cookie cookie2 = new Cookie("email", "aatish@gmail.com");
		Cookie cookie3 = new Cookie("address", "earth");
		
		cookie2.setMaxAge(0);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
		
		PrintWriter out = resp.getWriter();
		out.println("Cookie is sent");
	}
}
