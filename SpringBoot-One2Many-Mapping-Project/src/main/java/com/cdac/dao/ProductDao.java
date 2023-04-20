package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cdac.model.Products;

@Repository
public interface ProductDao extends JpaRepository<Products, Integer>{

}
