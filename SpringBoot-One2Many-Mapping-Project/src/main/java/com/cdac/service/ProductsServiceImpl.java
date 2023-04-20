package com.cdac.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdac.dao.ProductDao;
import com.cdac.model.Products;

@Service
public class ProductsServiceImpl implements ProductService {

	@Autowired
	private  ProductDao  productDao;

	@Override
	public void add(Products product) {
		productDao.save(product);

	}

	@Override
	public void modify(Products product) {
		productDao.save(product);

	}

	@Override
	public void deleteById(int id) {
		productDao.deleteById(id);

	}

	@Override
	public Products selectById(int id) {
		Optional<Products> opt = productDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Products> selectAll() {
		Iterable<Products> itr = productDao.findAll();
		List<Products> lst = new ArrayList<Products>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}

	@Override
	public List<Products> getAlPaginated(int pageNo, int sizeSize) {

		Pageable p = PageRequest.of(pageNo, sizeSize);
		return productDao.findAll(p).toList();
	}
	


}