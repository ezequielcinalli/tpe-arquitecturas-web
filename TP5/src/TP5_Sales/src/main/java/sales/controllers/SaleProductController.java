package sales.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sales.dtos.SaleProductAddDto;
import sales.dtos.SaleProductUpdateDto;
import sales.models.SaleProduct;
import sales.services.SaleProductService;

@RestController
@RequestMapping("SaleProducts")
public class SaleProductController {
	    
    @Autowired
    private final SaleProductService service;
    
    public SaleProductController(SaleProductService service){
       this.service = service; 
    }
    
    @GetMapping("/")
    public Iterable<SaleProduct> getAll(){
        return service.findAll();
    }
    
    @GetMapping("/{saleId}/{productId}")
    public Optional<SaleProduct> get(@PathVariable Integer saleId, @PathVariable Integer productId){
        return service.findById(saleId, productId);
    }
    
    @PostMapping("/")
    public SaleProduct save(@RequestBody SaleProductAddDto saleProductAddDto){
        return service.save(saleProductAddDto);
    }
    
    @PutMapping("/{saleId}/{productId}")
    public SaleProduct update(@RequestBody SaleProductUpdateDto saleProductUpdateDto, @PathVariable Integer saleId, @PathVariable Integer productId){
    	return service.update(saleId, productId, saleProductUpdateDto);                
    }
    
    @DeleteMapping("/{saleId}/{productId}")
    public void delete(@PathVariable Integer saleId, @PathVariable Integer productId){
        service.deleteById(saleId, productId);
    }
    
}