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

import com.cdac.model.Category;
import com.cdac.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	
	@PostMapping(value = { "/category" })
	public String add_Post(@RequestBody Category category) {
		categoryService.add(category);
		return "category added successfully";
	}

	
	@PutMapping(value = { "/category" })
	public String update_Post(@RequestBody Category category) {
		categoryService.modify(category);
		return "category updated successfully";
	}

	@DeleteMapping(value = { "/category" })
	public String delete_Post(@RequestParam int id) {
		System.out.println("first delete");
		categoryService.deleteById(id);
		return "category deleted successfully";
	}

	@DeleteMapping(value = { "/category/{id}" })
	public String delete_Post1(@PathVariable int id) {
		System.out.println("second delete");
		categoryService.deleteById(id);
		return "category deleted successfully";
	}

	@GetMapping(value = { "/category/{id}" })
	public Category get_Post_By_Id(@PathVariable int id) {
		return categoryService.selectById(id);
	}

	@GetMapping(value = { "/category" })
	public List<Category> get_All_Posts() {
		return categoryService.selectAll();
	}
	
	// get all in pages
	@GetMapping("/categoryPage")
	public List<Category> getAllPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
		return categoryService.getAlPaginated(pageNo, pageSize);

	}
	

//	// get all in pages and sorted
//	@GetMapping("/postsPageAndSort")
//	public List<Post> getAllPaginatedAndSorted (@RequestParam int pageNo, @RequestParam int pageSize,	@RequestParam String field) {
//		return postService.getAlPaginatedAndSorted(pageNo, pageSize, field);
//	
//	}

}