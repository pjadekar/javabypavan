package com.tcs.studentcrud.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tcs.studentcrud.connection.JDBCConnection;

public class Operation {
	Scanner sc = new Scanner(System.in);

	public void insertStudentData() {

		System.out.println("Enter the student Roll number");

		int rollNumber = sc.nextInt();

		System.out.println("Enter the student Name");

		String name = sc.next();

		System.out.println("Enter the student Address");

		String address = sc.next();

		Connection con = JDBCConnection.getJDBCConnection();
		String sql = "insert into Student values(?,?,?)";
		PreparedStatement prsmt = null;
		try {
			prsmt = con.prepareStatement(sql);

			prsmt.setInt(1, rollNumber);
			prsmt.setString(2, name);
			prsmt.setString(3, address);
			prsmt.execute();
			System.out.println("Data is inserted");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				if (null != prsmt) {

					prsmt.close();

				}
				if (null != con) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void deleteStudentByRollNumber() {

		System.out.println("Enter the student Roll number for student you want to delete");

		int rollNumber = sc.nextInt();
		Connection con = JDBCConnection.getJDBCConnection();

		String sql = "delete from Student where rollNo=?";
		PreparedStatement prsmt = null;
		try {
			prsmt = con.prepareStatement(sql);
			prsmt.setInt(1, rollNumber);

			prsmt.execute();

			System.out.println("Data is deleted");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				if (null != prsmt) {

					prsmt.close();

				}
				if (null != con) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void updateStudnetByRollNumber() {

		Connection con = JDBCConnection.getJDBCConnection();

		String sql = "update Student set name=? where rollNo=?";
		PreparedStatement prsmt = null;
		try {
			prsmt = con.prepareStatement(sql);
			prsmt.setString(1, "Pavan1234");
			prsmt.setInt(2, 20);

			prsmt.execute();

			System.out.println("data is updated");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != prsmt) {

					prsmt.close();

				}
				if (null != con) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void selectStudentByRollNumber() {

		Connection con = JDBCConnection.getJDBCConnection();

		String sql = "select * from Student where rollNo=?";
		PreparedStatement prsmt = null;
		try {
			prsmt = con.prepareStatement(sql);
			prsmt.setInt(1, 20);

			ResultSet rs = prsmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != prsmt) {

					prsmt.close();

				}
				if (null != con) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		Operation operation = new Operation();

		// operation.insertStudentData();
		// operation.deleteStudentByRollNumber();
		// operation.updateStudnetByRollNumber();
		operation.selectStudentByRollNumber();

	}

}
