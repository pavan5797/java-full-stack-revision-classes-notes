package com.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.Product;
import com.ecom.repo.ProductRepo;


@RestController
public class ProductController {
	@Autowired
	private ProductRepo pRepo;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product pr) {
		return pRepo.save(pr);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return pRepo.findAll();
	}
	
	@DeleteMapping("/product/{id}")  //localhost:8080/product/1
	public String deleteProduct(@PathVariable("id") int pid) {
		Product pr = getProduct(pid);
		if(pr == null)
			return "product does not exist";
		else
		{
			pRepo.delete(pr); 
			return "product deleted";  	 
		}
	}
	
	@GetMapping("/product/{id}")
	public Product searchProduct(@PathVariable("id") int pid)
	{
		return getProduct(pid);  // refer getProduct method for logic 
		/* if return type is String->
		Product pr= getProduct(pid);  
		if(pr==null)
			return "product not exist";
		else
			return pr.toString();
		*/
	}
	
	public Product getProduct(int pid) {
		Optional<Product> op= pRepo.findById(pid);
		Product pr = null;
		try {
			pr = op.get();
			return pr;
		}
		catch(Exception e){return null;}
	}
	
	@PutMapping("/updateproduct")
	public String updateProduct(@RequestBody Product pr)
	{
		Product dbpr = getProduct(pr.getId());
		if(dbpr == null)
			return "product not available to update";
		else {
			pRepo.save(pr);
			return "product updated";
		}
	}
}
