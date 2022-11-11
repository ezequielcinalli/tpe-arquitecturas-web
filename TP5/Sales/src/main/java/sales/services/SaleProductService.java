package sales.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.dtos.SaleProductAddDto;
import sales.dtos.SaleProductUpdateDto;
import sales.models.Sale;
import sales.models.SaleProduct;
import sales.models.SaleProductId;
import sales.repositories.SaleProductRepository;

@Service
public class SaleProductService {
	
    @Autowired
    private final SaleProductRepository repository;

    public SaleProductService(SaleProductRepository repository){
        this.repository = repository;
    }
    
    public Iterable<SaleProduct> findAll(){
        return repository.findAll();
    }
    
    public Optional<SaleProduct> findById(Integer saleId, Integer productId){
    	Sale sale = new Sale(); // TODO get actual sale with dto.saleId
        return repository.findById(new SaleProductId(sale, productId));
    }
    
    public SaleProduct save(SaleProductAddDto dto){
    	Sale sale = new Sale(); // TODO get actual sale with dto.saleId
    	SaleProduct SaleProduct = new SaleProduct(sale, dto.productId, dto.quantity, dto.unitPrice);
        return repository.save(SaleProduct);
    }
    
    public SaleProduct update(Integer saleId, Integer productId, SaleProductUpdateDto dto) {
    	Sale sale = new Sale(); // TODO get actual sale with dto.saleId
    	SaleProduct SaleProduct = repository.getReferenceById(new SaleProductId(sale, productId));
        SaleProduct.setQuantity(dto.quantity);
        SaleProduct.setUnitPrice(dto.unitPrice);
        return repository.save(SaleProduct);
    }
    
    public void deleteById(Integer saleId, Integer productId){
    	Sale sale = new Sale(); // TODO get actual sale with dto.saleId
        repository.deleteById(new SaleProductId(sale, productId));
    }

}
