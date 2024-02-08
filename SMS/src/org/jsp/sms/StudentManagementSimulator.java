package org.jsp.sms;

import java.sql.*;
import java.util.Scanner;

public class StudentManagementSimulator {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Student Management System\n");
		System.out.println("1. Add a new student record");
		System.out.println("2. Update percentage of existing student");
		System.out.println("3. View all student records");
		System.out.println("4. View particular student data");
		System.out.println("5. Delete a student data");
		System.out.println("\n\nChoose your operation");

		int choice = sc.nextInt();
		switch(choice) {
		case 1:
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
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
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
			} catch (ClassNotFoundException | SQLException e) {
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
			break;
		case 2:
			System.out.println("Enter the student id");
			int sid1 = sc.nextInt();
			System.out.println("Enter student username");
			String suname1 = sc.next();
			System.out.println("Enter percentage obtained");
			double sperc1 = sc.nextDouble();		
			String qry2 = "Update student.sms set perc=? where id=? and username=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
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

			} catch (ClassNotFoundException | SQLException e) {
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
			break;
		case 3:
			String qry3 = "Select * from student.sms";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
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
			} catch (ClassNotFoundException | SQLException e) {
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
			break;
		case 4:
			String qry4 = "select * from student.sms where id=?";
			System.out.println("Enter the student id");
			int sid3 = sc.nextInt();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
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
			} catch (ClassNotFoundException | SQLException e) {
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
			break;
		case 5:
			String qry5 = "delete from student.sms where id=? and username=?";
			System.out.println("Enter the student id");
			int sid4 = sc.nextInt();
			System.out.println("Enter username");
			String suname3 = sc.next();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
				pstmt = con.prepareStatement(qry5);	
				pstmt.setInt(1, sid4);
				pstmt.setString(2, suname3);
				int val = pstmt.executeUpdate(); //creating implementation class object of result set
				if(val==1) {
					System.out.println("Record has been deleted");
				}else {
					System.err.println("Invalid Credentials");
				}
			} catch (ClassNotFoundException | SQLException e) {
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
			break;
		default: 
			System.out.println("Wrong option selected");
			break;
		}

	}
}
