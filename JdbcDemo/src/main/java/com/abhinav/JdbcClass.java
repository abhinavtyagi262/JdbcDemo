package com.abhinav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class JdbcClass {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/database1";
		String uname = "root";
		String password = "root";
		String query = "select name,age from emp where id = '1' ";

//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, password);
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String name = rs.getString(1);
			System.out.println(name);
			
			String age = rs.getString(2);
			System.out.println(age);
		}

		con.close();
		ps.close();
		rs.close();
	}
}
