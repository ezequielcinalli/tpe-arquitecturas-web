package sales.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.dtos.SaleSaveDto;
import sales.models.Sale;
import sales.repositories.SaleRepository;

@Service
public class SaleService {
	
    @Autowired
    private final SaleRepository repository;

    public SaleService(SaleRepository repository){
        this.repository = repository;
    }
    
    public Iterable<Sale> findAll() {
        return repository.findAll();
    }
    
    public Optional<Sale> findById(int id) {
        return repository.findById(id);
    }
    
    public Sale save(SaleSaveDto dto) {
    	Sale sale = new Sale(dto.customerId, dto.date);
        return repository.save(sale);
    }
    
    public Sale update(int id, SaleSaveDto dto) {
    	Sale sale = repository.getReferenceById(id);
        sale.setCustomerId(dto.customerId);
        sale.setDate(dto.date);
        return repository.save(sale);
    }
    
    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
    public float getCustomerTotalAmountSpent(int customerId) {
    	return repository.getCustomerTotalAmountSpent(customerId);
    }

}
