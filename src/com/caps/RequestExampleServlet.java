package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestExample")
public class RequestExampleServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("The Http Method is: "+req.getMethod());
		out.println("The Url is: "+req.getRequestURL());
		out.println("The Protoco is: "+req.getProtocol());
		String[] data = req.getParameterValues("data");
		out.println("Data: "+ data[0]);
		String[] nums = req.getParameterValues("nums");
		out.println(Arrays.toString(nums));
		resp.sendError(500,"Something went wrong in the server side");
	}
}
