package com.cdac.service;

import java.util.List;

import com.cdac.model.Category;


public interface CategoryService {
	
	void add(Category category);

	void modify(Category category);

	void deleteById(int id);

	Category selectById(int id);

	List<Category> selectAll();
	
	List<Category> getAlPaginated(int pageNo, int sizeSize);
//	
//	 List<Post> getAlPaginatedAndSorted(int pageNo, int sizeSize, String field);

	
}