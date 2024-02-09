package org.jsp.sms;

import java.util.Scanner;

public class StudentManagementSimulator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Student Management System\n");
		System.out.println("1. Add a new student record");
		System.out.println("2. Update percentage of existing student");
		System.out.println("3. View all student records");
		System.out.println("4. View particular student data");
		System.out.println("5. Delete a student data");
		System.out.println("\n\nChoose your operation");
		SMSFunctions sf = new SMSFunctions();

		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			sf.addStudentRecord();
			break;
		case 2:
			sf.updateStudentRecord();
			break;
		case 3:
			sf.getAllStudentRecord();
			break;
		case 4:
			sf.getStudentRecordWithID();
			break;
		case 5:
			sf.deleteRecordWithID();
			break;
		default: 
			System.out.println("Wrong option selected");
			break;
		}
		sc.close();
	}
}
