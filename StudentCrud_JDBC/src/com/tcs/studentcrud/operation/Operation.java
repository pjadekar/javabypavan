package com.tcs.studentcrud.operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.tcs.studentcrud.connection.JDBCConnection;

public class Operation {
	
    Scanner sc =new Scanner(System.in) ;
    
	
	public void insertStudentData() {
		
		System.out.println("Enter the student Roll number");
		
		int rollNumber=sc.nextInt();
		
		System.out.println("Enter the student Name");
		
		String name=sc.next();
		
		System.out.println("Enter the student Address");
		
		String address=sc.next();
		
	Connection con=	JDBCConnection.getJDBCConnection();
	
	String sql= "insert into Student values("+rollNumber+","+"'"+name+"'"+","+"'"+address+"'"+")";
	
		System.out.println(sql);
		Statement smt=null;
		try {
			 smt=con.createStatement();
			 smt.execute(sql);
			 System.out.println("Student data is inserted successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
	}
	
	public void selectStudentdataByRollNumber() {

		System.out.println("Enter the student Roll number");

		int rollNumber = sc.nextInt();

		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "select * from Student where rollNo=" + rollNumber + "";
		System.out.println(sql);
		try {
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {

				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	public void deleteStudentByRollNumber() {
		System.out.println("Enter the student Roll number for student you want to delete");

		int rollNumber = sc.nextInt();
		Connection con = JDBCConnection.getJDBCConnection();
		
		String sql="delete from Student where rollNo=" + rollNumber + "";
		System.out.println(sql);
		
		try {
			Statement smt=con.createStatement();
			smt.execute(sql);
			System.out.println("Student data is deleted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStudentByRollNumber() {
		
		System.out.println("Enter the student Roll number for student you want to update");

		int rollNumber = sc.nextInt();
		Connection con = JDBCConnection.getJDBCConnection();
		
        System.out.println("Enter the student Name");
		
		String name=sc.next();
		
		String sql="update Student set name="+"'"+name+"'"+"where rollNo=" + rollNumber + "";
		System.out.println(sql);
		try {
			Statement smt=con.createStatement();
			smt.execute(sql);
			System.out.println("Student data is updated");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Operation operation=new Operation();
		
		while(true) {
			
			System.out.println("Please Enter your choise");
			System.out.println("Press 1 to Insert Student data");
			System.out.println("Press 2 to select Student data by RollNumber");
			System.out.println("Press 3 to delete Student data by RollNumber");
			System.out.println("Press 4 to update Student data by RollNumber");
			
		int choise=	sc.nextInt();
		
		switch(choise) {
		
		case 1:
			operation.insertStudentData();
			break;
		case 2:
			operation.selectStudentdataByRollNumber();
			break;
		case 3:
			operation.deleteStudentByRollNumber();
			break;
			
		case 4:
			operation.updateStudentByRollNumber();
			break;
			
		default:
			
			System.out.println("Thanks for connecting with us");
			break;
			
		}
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
	
	}
	
	public void Mytask() {
		
		
		/////////////////asdfadfasdfasd
		//asdfasdfasdffasdfsfasd
		
	}
	
	

}
