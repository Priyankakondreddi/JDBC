package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableAndGetTableData {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","Priya","Priya123"
				);
		Statement stmt=con.createStatement();
		stmt.execute(
				"""
				CREATE table student_information(
				stuId number(5),
				stuName varchar2(20),
				stuRoll_no number(5),
				stuAddress number(30),
				dateOfAdmission date)
				"""
				);
		ResultSet rs=stmt.executeQuery("Select * from student_info");
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println("Number of columns : "+rsmd.getColumnCount());
		System.out.println("Columns: ");
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
			System.out.print(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i)+" "+rsmd.getColumnDisplaySize(i)+" ");
		}
	}

}
