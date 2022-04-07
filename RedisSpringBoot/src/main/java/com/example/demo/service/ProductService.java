package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;

public interface ProductService {

	



	public List<Product> getAllProduct();
	Product update(Product product);

	Product get(int id);

	void delete(Product product);

	Product save(Product product);



}
