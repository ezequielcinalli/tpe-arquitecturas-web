package com.tp5.products.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp5.products.Dtos.ProductAddDto;
import com.tp5.products.Dtos.ProductUpdateDto;
import com.tp5.products.Models.Product;
import com.tp5.products.Repositories.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
	
	@Autowired
    private final ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		 this.repository = repository;
	}
	 
	public Iterable<Product> findAll(){
        return repository.findAll();
    }
    
    public Optional<Product> findById(Integer id){
        return repository.findById(id);
    }
    
	public Product save(ProductAddDto Product){
	    return repository.save(new Product(Product.name, Product.price));
	}
	
	public Product update(ProductUpdateDto Product, Integer ID){
	    Product oldCustomer = findById(ID).get();
	    oldCustomer.setName(Product.name);
	    return repository.save(oldCustomer);
	}
	
	public void deleteById(Integer id){
	    repository.deleteById(id);
	}
}