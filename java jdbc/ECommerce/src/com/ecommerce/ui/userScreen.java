package com.ecommerce.ui;

import java.util.Scanner;

import com.ecommerce.daoimpl.UserDaoImpl;
import com.ecommerce.model.user;

public class userScreen {
	
	Scanner sc = new Scanner(System.in);
	
	public void init() {
		int ch;
		String email,pass,name;
		boolean status = true;
		
		
		UserDaoImpl us = new UserDaoImpl();
		do {
			System.out.println("1 .login");
			System.out.println("2 .register");
			System.out.println("0 .exit");
			
			System.out.println("enter your choice");
			ch = sc.nextInt();
			
		    switch(ch)
		    {
			    case 1 : 
			    	System.out.println("enter email");
			    	email = sc.next();
			    	System.out.println("enter password");
			    	pass = sc.next();
			    	status = us.userLogin(email, pass); // here logic for checking id and password and return boolean
			    	
			    	if(status == true)
			    	{
			    		System.out.println("logged in");
			    		usermenu();   // display menu
			    	}
			    	else System.out.println("enter correct id and passsword");
			    break;
			    case 2 : 
			    	System.out.println("enter name");
			    	name = sc.next();
			    	System.out.println("enter email");
			    	email =sc.next();
			    	System.out.println("enter password");
			    	pass = sc.next();
			    	
			    	user a = new user();
			    	a.setName(name);
			    	a.setEmail(email);
			    	a.setPassword(pass);
			    	
			    	status = us.register(a);
			    	if(status == true)
			    	{
			    	System.out.println("registered succesfully");
			    	}
			    	else {
			    		System.out.println("sorry try again..");
			    	}
			    break;
			    case 0 : System.out.println("exited from user");
			    break;
			    default :System.out.println("enter correct choice");
		    }
		}while(ch !=0);
		
	}
	
	public void usermenu()
	{
		int ch;
		
		do {
			System.out.println("1 .list all products");
			System.out.println("2 .Search product by id");
			System.out.println("3 .add to cart");
			System.out.println("4 .showbill / check out");
			System.out.println("0 .logout");
			
			System.out.println("enter your choice");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1 : 
					System.out.println(" listed all products");
				break;
				case 2 : 
					System.out.println(" Search product by id");
				break;
				case 3 : 
					System.out.println(" add to cart");
				break;
				case 4 : 
					System.out.println(" showbill / check ou");
				break;
				case 0 : 
					System.out.println("logged out from user");
				break;
				
			}
			
		}while(ch !=0);
	}
}
