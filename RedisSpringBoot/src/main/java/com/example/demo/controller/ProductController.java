package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
    @PostMapping("/create")
	public Product createProduct(@RequestBody Product Product) {
		Product createResponse = productService.save(Product);
		return createResponse;
	}
    
    @GetMapping("/allproduct")
    public ResponseEntity<List<Product>> getAllProduct()
    {
    	return ResponseEntity.ok(productService.getAllProduct());
    }
   
    @PutMapping("/update")
	public Product updateProduct(@RequestBody Product Product) {
		Product updateResponse = productService.update(Product);
		return updateResponse;
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		Product getReponse = productService.get(id);
		return getReponse;
	}

	@DeleteMapping("/delete")
	public String deleteProduct(@RequestBody Product Product) {
		productService.delete(Product);
		return "Record deleted succesfully";
	}

	

}
