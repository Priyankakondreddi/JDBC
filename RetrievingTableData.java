package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class RetrievingTableData{

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","Priya","Priya123"
						);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from product");
		ResultSetMetaData rsmd=rs.getMetaData();
		
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		System.out.println("\n-----------------------------------------------------");
		if(rs.next())
		{
			do {
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					System.out.print(rs.getString(i)+"\t\t");
				}
				System.out.println();
			}while(rs.next());
		}
		else
		{
			System.out.println("no rows selected");
		}
		
		rs.close();
		stmt.close();
		con.close();
	}

}
