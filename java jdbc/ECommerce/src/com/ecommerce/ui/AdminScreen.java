package com.ecommerce.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.ecommerce.daoimpl.ProductDaoImpl;
import com.ecommerce.model.Product;

public class AdminScreen {
	Scanner sc = new Scanner(System.in);

	ProductDaoImpl pDao = new ProductDaoImpl();

	// read product information from console and convert input into Product object
	private Product readProduct() {
		System.out.println("Enter name of product ");
		String prName = sc.next(); // laptop

		System.out.println("Enter Price of product ");
		float prPrice = sc.nextFloat();

		System.out.println("Enter desc for product ");
		String prDesc = sc.nextLine();

		Product pr = new Product();
		pr.setName(prName);
		pr.setPrice(prPrice);
		pr.setDesc(prDesc);

		return pr;
	}

	public void adminMenu() {
		int ch = 0,id;
		Product pr = null;
		boolean status = false;
		do {
			System.out.println("1. Add a new Product");
			System.out.println("2. List all Products");
			System.out.println("3. Update a Product");
			System.out.println("4. Delete a Product");
			System.out.println("5. Search Product by Id");
			System.out.println("0. Logout");

			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("add product");
				pr = readProduct();
				status = pDao.addProduct(pr);
				if (status == true)
					System.out.println("product added");
				else
					System.out.println("sorry could not add product");
				break;
			case 2:
				ArrayList<Product> lst = pDao.getAllProducts();
				if(lst.isEmpty()==true)
					System.out.println("no products in DB");
				else
				{
					for(int i=0;i<lst.size();i++)
					{
						pr = lst.get(i);
						System.out.println(pr);
					}
				}
				
				break;
			case 3:
				System.out.println("Enter Id ");
				id = sc.nextInt();
				pr = readProduct();
				pr.setId(id);
				status = pDao.updateProduct(pr);
				if (status == true)
					System.out.println("product updated");
				else
					System.out.println("sorry could not update product");
				
				break;
			case 4:
				System.out.println("Enter Id ");
				id = sc.nextInt();
				status = pDao.removeProduct(id);
				if (status == true)
					System.out.println("product deleted");
				else
					System.out.println("sorry could not delete product");
				
				break;
			case 5:
				System.out.println("Enter Id ");
				id = sc.nextInt();
				pr = pDao.searchProductById(id);
				if(pr==null)
					System.out.println("product not found...");
				else
					System.out.println(pr);
				break;
			case 0:
				System.out.println("Bye Admin");
				break;
			default:
				System.out.println("Wrong input");
			}
		} while (ch != 0);
	}
}
