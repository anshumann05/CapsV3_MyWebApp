package com.caps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/showStudents")
public class ShowStudents extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		if(session != null) {
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
				String sql = "select * from students_info";

				int count = 0;
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);

				/*
				 * 4. Process the results
				 */

				while(rs.next()){
					int regno = rs.getInt(1);
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
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			out.println("You don't have the permission. Please Login");
		}
		
	}
}
