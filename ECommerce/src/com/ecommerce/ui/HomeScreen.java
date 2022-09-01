package com.ecommerce.ui;

import java.util.Scanner;

import com.ecommerce.daoimpl.AdminDaoImpl;

public class HomeScreen {
	public static void main(String[] args) {
		int ch = 0;
		String email;
		String pass;
		boolean status = true;
		
		AdminScreen adUi = new AdminScreen();
		userScreen userUi = new userScreen();		 
		
		AdminDaoImpl adminDao = new AdminDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Admin");
			System.out.println("2. User");
			System.out.println("0. Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter email ");
				email = sc.next();
				
				System.out.println("Enter password ");
				pass = sc.next();
				
				status = adminDao.adminLogin(email, pass);
				
				if(status == true)
				{
					System.out.println("welcome admin");
					adUi.adminMenu();
				}
				else
				{
					System.out.println("Email and password does not match...");
				}
				break;

			case 2:
				System.out.println("welcome user");
				userUi.init();
				break;
			case 0:
				System.out.println("good bye");
				break;
			default:
				System.out.println("invalid input");
			}
		} while (ch != 0);
	}
}
