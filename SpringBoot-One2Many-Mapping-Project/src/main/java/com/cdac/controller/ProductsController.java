package com.cdac.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.model.Products;
import com.cdac.service.ProductService;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductService productService;

	@PostMapping(value = { "/product" })
	public String add_Post(@RequestBody Products product) {
		productService.add(product);
		return "product added successfully";
	}

	@PutMapping(value = { "/product" })
	public String update_Post(@RequestBody Products product) {
		productService.modify(product);
		return "product updated successfully";
	}

	@DeleteMapping(value = { "/product" })
	public String delete_Post(@RequestParam int id) {
		System.out.println("first delete");
		productService.deleteById(id);
		return "product deleted successfully";
	}

	@DeleteMapping(value = { "/product/{id}" })
	public String delete_Post1(@PathVariable int id) {
		System.out.println("second delete");
		productService.deleteById(id);
		return "product deleted successfully";
	}

	@GetMapping(value = { "/product/{id}" })
	public Products get_Post_By_Id(@PathVariable int id) {
		return productService.selectById(id);
	}

	@GetMapping(value = { "/products" })
	public List<Products> get_All_Posts() {
		return productService.selectAll();
	}
	
	// get all in pages
	@GetMapping("/productssPage")
	public List<Products> getAllPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
		return productService.getAlPaginated(pageNo, pageSize);

	}
	


}