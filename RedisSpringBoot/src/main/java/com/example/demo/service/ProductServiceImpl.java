package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.exception.OrderExceptionNotFound;
import com.example.demo.model.Product;

import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	@CachePut(value = "Product", key = "#Product.id")
	public Product save(Product Product) {
		Product createResponse = productRepo.save(Product);
		return createResponse;
	}

	@Override
	@Cacheable(value = "Product", key = "#id")
	public Product get(int id) {
		Product Product = null;
		Optional<Product> ProductResponse = productRepo.findById(id);
		if (ProductResponse.isPresent()) {
			Product = ProductResponse.get();
		} else {
			throw new RuntimeException("Record not found");
		}
		return Product;
	}

	@Override
	@CachePut(value = "Product", key = "#Product.id")
	public Product update(Product Product) {
		Product updateResponse = productRepo.save(Product);
		return updateResponse;
	}

	@Override
	@CacheEvict(value = "Product", key = "#Product.id")
	public void delete(Product Product) {
		productRepo.delete(Product);
	}

	@Override
	@Cacheable(value = "Product")
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

}
