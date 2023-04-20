package com.cdac.service;

import java.util.List;

import com.cdac.model.Category;
import com.cdac.model.Products;


public interface ProductService {
	
	void add(Products product);

	void modify(Products product);

	void deleteById(int id);

	Products selectById(int id);

	List<Products> selectAll();
	
	List<Products> getAlPaginated(int pageNo, int sizeSize);
//	
//	 List<Post> getAlPaginatedAndSorted(int pageNo, int sizeSize, String field);

	
}