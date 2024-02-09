package org.jsp.sms;

import java.sql.*;

import java.util.Scanner;

public class SMSFunctions {
	static Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Scanner sc = new Scanner(System.in);
	
	/**
	 * This method helps to add a student record into the database. The record must have student id, name, username, password and percentage.
	 */
	void addStudentRecord() {
		System.out.println("Enter id");
		int sid = sc.nextInt();
		System.out.println("Enter name");
		String sname = sc.next();
		System.out.println("Enter username");
		String suname = sc.next();
		System.out.println("Enter password");
		String spass = sc.next();
		System.out.println("Enter percentage");
		double sperc = sc.nextDouble();
		String qry1 = "Insert into student.sms values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(qry1);
			pstmt.setInt(1, sid);
			pstmt.setString(2, sname);
			pstmt.setString(3,suname);
			pstmt.setString(4, spass);
			pstmt.setDouble(5, sperc);		
			int val = 0;
			val = pstmt.executeUpdate();
			if(val == 1) {
				System.out.println("Student record added");
			}else {
				System.err.println("Failed to add record");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			sc.close();
			if(rs!=null && pstmt!= null && con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This method helps to update the existing record of a student. It takes id and username for the authentication purpose.
	 * If the entered credentials are correct, the record will be updated with the new record.
	 */
	void updateStudentRecord() {
		System.out.println("Enter the student id");
		int sid1 = sc.nextInt();
		System.out.println("Enter student username");
		String suname1 = sc.next();
		System.out.println("Enter percentage obtained");
		double sperc1 = sc.nextDouble();		
		String qry2 = "Update student.sms set perc=? where id=? and username=?";
		try {
			pstmt = con.prepareStatement(qry2);	
			pstmt.setDouble(1, sperc1);
			pstmt.setInt(2, sid1);
			pstmt.setString(3, suname1);
			pstmt.executeUpdate();
			int val = 0;
			val = pstmt.executeUpdate();
			if(val == 1) {
				System.out.println("Student record updated");
			}else {
				System.err.println("Failed to update record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			sc.close();
			if(rs!=null && pstmt!= null && con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This method helps to fetch all the records present in the database.
	 */
	void getAllStudentRecord() {
		String qry3 = "Select * from student.sms";
		try {
			pstmt = con.prepareStatement(qry3);	
			rs = pstmt.executeQuery(); //creating implementation class object of result set
			System.out.println("ID\tName\tUsername\tPerc");
			System.out.println("---------------------------------------");
			while(rs.next()) {
				int sid2 = rs.getInt(1);
				String sname1 = rs.getString("name");
				String suname2 = rs.getString(3);
				double sperc2 = rs.getDouble(5);
				System.out.println(sid2+"\t"+sname1+"\t"+suname2+"\t"+sperc2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			sc.close();
			if(rs!=null && pstmt!= null && con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This method help us to find the record of a particular student on the basis of given id.
	 */
	void getStudentRecordWithID() {
		String qry4 = "select * from student.sms where id=?";
		System.out.println("Enter the student id");
		int sid3 = sc.nextInt();
		try {
			pstmt = con.prepareStatement(qry4);	
			pstmt.setInt(1, sid3);
			rs = pstmt.executeQuery(); //creating implementation class object of result set
			System.out.println("ID\tName\tUsername\tPerc");
			System.out.println("---------------------------------------");
			while(rs.next()) {
				int sid2 = rs.getInt(1);
				String sname1 = rs.getString("name");
				String suname2 = rs.getString(3);
				double sperc2 = rs.getDouble(5);
				System.out.println(sid2+"\t"+sname1+"\t"+suname2+"\t"+sperc2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			sc.close();
			if(rs!=null && pstmt!= null && con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This method deletes a record from the database with the given id and username.
	 */
	void deleteRecordWithID() {
		String qry5 = "delete from student.sms where id=? and username=?";
		System.out.println("Enter the student id");
		int sid4 = sc.nextInt();
		System.out.println("Enter username");
		String suname3 = sc.next();
		try {
			pstmt = con.prepareStatement(qry5);	
			pstmt.setInt(1, sid4);
			pstmt.setString(2, suname3);
			int val = pstmt.executeUpdate(); //creating implementation class object of result set
			if(val==1) {
				System.out.println("Record has been deleted");
			}else {
				System.err.println("Invalid Credentials");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			sc.close();
			if(rs!=null && pstmt!= null && con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
