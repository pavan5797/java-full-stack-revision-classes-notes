package com.ecommerce.dao;

import java.util.ArrayList;

import com.ecommerce.model.Product;

public interface ProductDao {
	boolean addProduct(Product pr);
	boolean removeProduct(int id);
	boolean updateProduct(Product pr);
	Product searchProductById(int id);
	ArrayList<Product> getAllProducts();
}
