package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		
		//1. Loading the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully");
		
		//2. Establish the Connection
		Connection con = 
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL",
					"Priya", "Priya123");
			System.out.println("Connection is created");
			
		//3. Create Statement
		Statement stmt=con.createStatement();
		System.out.println("Statement Created Successfully");
			
		//4. Execute the statements
		String product_table=
				""" 
				CREATE table product(
				product_id number(5),product_name varchar2(30),price number(7,2))
				""";
		String customers=
				"""
				CREATE table customer(
				id number(5),
				name varchar2(20),
				price number(8,2))
				""";
		String orders=
				"""
				CREATE table orders(
				order_id number(5),
				item varchar2(20))
				""";
		String product_seq=
				"""
				CREATE sequence product_seq
				start with 1
				increment by 1 
				""";
		String customer_seq=
				"""
				CREATE sequence customer_seq
				start with 1
				increment by 1 
				""";
		String order_seq=
				"""
				CREATE sequence order_seq
				start with 1
				increment by 1 
				""";
		stmt.execute(product_table);
		System.out.println("Product Table created successfully");
		stmt.execute(customers);
		System.out.println("Product Table created successfully");
		stmt.execute(orders);
		System.out.println("Tables created successfully");
		stmt.execute(product_seq);
		stmt.execute(customer_seq);
		stmt.execute(order_seq);
		System.out.println("Sequences Created successfully");
		
		//5. close the connection
		stmt.close();
		con.close();
		
		
	}

}
