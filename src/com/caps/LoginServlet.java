package com.caps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Driver;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("regno");
		String password = req.getParameter("passwd");
		
		System.out.println(regno);
		System.out.println(password);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PrintWriter out = resp.getWriter();
		
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");
			
			String dbUrl="jdbc:mysql://localhost:3306/capsV3_db";
			String filePath = "F:/Files/db.properties";
			FileReader reader = new FileReader(filePath);
			Properties prop = new Properties();
			prop.load(reader);
			
			con = DriverManager.getConnection(dbUrl, prop);
			
			System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info where sid=? and password=?";

			int count = 0;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(regno));
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			/*
			 * 4. Process the results
			 */
			
			
			if(rs.next()){
				HttpSession session = req.getSession();
				session.setAttribute("username", rs.getString("firstname"));
				regno = rs.getInt(1)+"";
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String isAdmin = rs.getString(4);
				String passwd = rs.getString(5);

				out.println(regno);
				out.println(firstname);
				out.println(lastname);
				out.println(isAdmin);
				out.println(passwd);
				out.println("*********************");
			}else {
				resp.sendRedirect("./Login.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
