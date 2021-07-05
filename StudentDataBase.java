package com.te.assignment;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDataBase {
	String url = "jdbc:mysql://localhost:3306/new_yash";
	String user = "root";
	String pwd = "yash";
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	PreparedStatement p = null;
	
	public void Insert() {

		try {
			for (;;) {
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				sc.nextLine();
				System.out.println("enter the gender");
				String gender = sc.next();
				sc.nextLine();
				System.out.println("Enter the marks");
				Double marks = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the address");
				String address = sc.nextLine();
				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection(url, user, pwd);

				String query = "insert into Student_info values(?,?,?,?,?)";
				p = con.prepareStatement(query);
				p.setInt(1, id);
				p.setString(2, name);
				p.setString(3, gender);
				p.setDouble(4, marks);
				p.setString(5, address);
				int result = p.executeUpdate();
				if (result != 0) {
					System.out.println("no of rows effecteed" + result);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update() {
		System.out.println("Enter the id to be updated");
		int id = sc.nextInt();
		System.out.println("Enter the name to be updated");
		String name = sc.next();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String query1 = "update Student_info set Name=? where Id=?";
			p = con.prepareStatement(query1);
			p.setInt(2, id);
			p.setString(1, name);
			int result = p.executeUpdate();
			if (result != 0) {
				System.out.println("updated" + result);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void Select() {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String query2="select * from student_info";
			Statement stmt = con.createStatement();

			ResultSet result = stmt.executeQuery(query2);
			while(result.next()) {
				System.out.println("id:"+result.getInt(1));
				System.out.println("name:"+result.getString(2));
				System.out.println("address:"+result.getString(3));
				System.out.println("address:"+result.getDouble(4));
				System.out.println("address:"+result.getString(5));
			
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public void Delete() {
		try {
			System.out.println("enter the id u wanna delete");
			int id=sc.nextInt();
			con = DriverManager.getConnection(url, user, pwd);
			String query1 = "delete from Student_info where id=?";
			p = con.prepareStatement(query1);
			p.setInt(1, id);
			int result = p.executeUpdate();
			if (result != 0) {
				System.out.println("DELETED" + result);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}	
			
				
	}
}


