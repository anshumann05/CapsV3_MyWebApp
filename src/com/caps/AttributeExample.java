package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attributeCtx")
public class AttributeExample extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Dog dog = new Dog();
		dog.setName("Scooby");
		dog.setColor("Black");
		dog.setBreed("German Shephard");
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("dog", dog);
		
		PrintWriter out = resp.getWriter();
		out.println("Dog is kept inside Servlet Context");
	}
}
