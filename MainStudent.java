package com.te.assignment;

import java.util.Scanner;

public class MainStudent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1.Insert \n 2.Update \n 3.select \n4.Delete");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			new StudentDataBase().Insert();
			break;
		case 2:
			new StudentDataBase().update();
			break;
		case 3:
			new StudentDataBase().Select();
			break;
		case 4:
			new StudentDataBase().Delete();
			break;
		default:
			System.exit(0);
		}

	}

}
