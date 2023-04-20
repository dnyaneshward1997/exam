package com.cdac.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdac.dao.CategoryDao;
import com.cdac.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private  CategoryDao  categoryDao;

	@Override
	public void add(Category category) {
		categoryDao.save(category);

	}

	@Override
	public void modify(Category category) {
		categoryDao.save(category);

	}

	@Override
	public void deleteById(int id) {
		categoryDao.deleteById(id);

	}

	@Override
	public Category selectById(int id) {
		Optional<Category> opt = categoryDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Category> selectAll() {
		Iterable<Category> itr = categoryDao.findAll();
		List<Category> lst = new ArrayList<Category>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}

	@Override
	public List<Category> getAlPaginated(int pageNo, int sizeSize) {

		Pageable p = PageRequest.of(pageNo, sizeSize);
		return categoryDao.findAll(p).toList();
	}
	
//	@Override
//	public List<Post> getAlPaginatedAndSorted(int pageNo, int sizeSize, String field) {
//
//		Pageable p = PageRequest.of(pageNo, sizeSize, Direction.ASC, field);
//		return postDao.findAll(p).toList();
//	}

}