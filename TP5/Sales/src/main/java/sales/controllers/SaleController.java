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

import sales.dtos.SaleSaveDto;
import sales.models.Sale;
import sales.services.SaleService;

@RestController
@RequestMapping("sales")
public class SaleController {
	    
    @Autowired
    private final SaleService service;
    
    public SaleController(SaleService service){
       this.service = service; 
    }
    
    @GetMapping("/")
    public Iterable<Sale> getAll(){
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Sale> get(@PathVariable Integer id){
        return service.findById(id);
    }
    
    @PostMapping("/")
    public Sale save(@RequestBody SaleSaveDto saleSaveDto){
        return service.save(saleSaveDto);
    }
    
    @PutMapping("/{id}")
    public Sale update(@RequestBody SaleSaveDto saleSaveDto, @PathVariable Integer id){
    	return service.update(id, saleSaveDto);                
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteById(id);
    }
    
    @GetMapping("/amount/{customerId}")
    public float getCustomerTotalAmountSpent(@PathVariable Integer customerId){
        return service.getCustomerTotalAmountSpent(customerId);
    }
    
}
