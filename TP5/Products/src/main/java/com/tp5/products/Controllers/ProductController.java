package com.tp5.products.Controllers;

import java.util.Optional;
import com.tp5.products.Services.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp5.products.Dtos.ProductAddDto;
import com.tp5.products.Dtos.ProductUpdateDto;
import com.tp5.products.Models.Product;
import com.tp5.products.Services.ProductService;

@RestController
@Api(tags = "products", description = "Servicio de Productos")
@RequestMapping("products")
public class ProductController {
	    
	    @Autowired
	    private final ProductService service;
		@Autowired
		private final AuthService authService;
	    
	    public ProductController(ProductService service, AuthService authService){
	       this.service = service; 
		   this.authService = authService;
	    }
	    
	    @GetMapping("/")
	    public Iterable<Product> getProducts(){
	        return service.findAll();
	    }
	    
	    @GetMapping("/{ID}")
	    public Optional<Product> getProductByID(@PathVariable Integer ID){
	        return service.findById(ID);
	    }
	    
	    @PostMapping("/")
	    public Product save(@RequestBody ProductAddDto Product){
	        return service.save(Product);
	    }
	    
	    @PutMapping("/{ID}")
	    public Product update(@RequestBody ProductUpdateDto Product, @PathVariable Integer ID){
	    	return service.update(Product, ID);                
	    }
	    
	    @DeleteMapping("/{ID}")
	    public void delete(@PathVariable Integer ID){
	        service.deleteById(ID);
	    }
}
