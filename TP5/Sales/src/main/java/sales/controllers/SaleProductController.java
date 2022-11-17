package sales.controllers;

import java.util.Optional;

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
import sales.dtos.SaleProductAddDto;
import sales.dtos.SaleProductUpdateDto;
import sales.models.SaleProduct;
import sales.services.SaleProductService;

@RestController
@Api(tags = "sales-products", description = "Servicio de detalle de ventas")
@RequestMapping("sales-products")
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
    
    @GetMapping("/{saleProductId}")
    public Optional<SaleProduct> get(@PathVariable Integer saleProductId){
        return service.findById(saleProductId);
    }
    
    @PostMapping("/")
    public SaleProduct save(@RequestBody SaleProductAddDto saleProductAddDto){
        return service.save(saleProductAddDto);
    }
    
    @PutMapping("/{saleProductId}")
    public SaleProduct update(@RequestBody SaleProductUpdateDto saleProductUpdateDto, @PathVariable Integer saleProductId){
    	return service.update(saleProductId, saleProductUpdateDto);                
    }
    
    @DeleteMapping("/{saleProductId}")
    public void delete(@PathVariable Integer saleProductId){
        service.deleteById(saleProductId);
    }
    
}