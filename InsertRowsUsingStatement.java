package com.java.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class InsertRowsUsingStatement {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		//1. Loading the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. establish the connection
		Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","Priya","Priya123"
				);
		
		//3. Statement creation
		Statement stmt=con.createStatement();
		
		//4. execute statements
		stmt.executeUpdate(
				"""
				INSERT into product(product_id,product_name,price)
				values(product_seq.nextval,'laptop',20000)
				""");
		stmt.executeUpdate(
				"""
				INSERT into product(product_id,product_name,price)
				values(product_seq.nextval,'camera',10000)
				""");
		System.out.println("inserted into product table");
		stmt.executeUpdate(
				"""
				INSERT into customer(id,name,price)
				values(customer_seq.nextval,'cany',1000)
				""");
		stmt.executeUpdate(
				"""
				INSERT into customer(id,name,price)
				values(customer_seq.nextval,'scott',8000)
				""");
		System.out.println("inserted into customer table");
		stmt.executeUpdate(
				"""
				INSERT into orders(order_id,item)
				values(order_seq.nextval,'smith')
				""");
		stmt.executeUpdate(
				"""
				INSERT into orders(order_id,item)
				values(order_seq.nextval,'scott')
				""");

		System.out.println("inserted into order table");
		
		//5. close connections
		stmt.close();
		con.close();
		
				

	}

}
