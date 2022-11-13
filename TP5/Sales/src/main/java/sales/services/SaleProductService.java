package sales.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.dtos.SaleProductAddDto;
import sales.dtos.SaleProductUpdateDto;
import sales.models.Sale;
import sales.models.SaleProduct;
import sales.repositories.SaleProductRepository;
import sales.repositories.SaleRepository;

@Service
public class SaleProductService {
	
    @Autowired
    private final SaleProductRepository saleProductRepository;
    @Autowired
    private final SaleRepository saleRepository;

    public SaleProductService(SaleProductRepository repository, SaleRepository saleRepository){
        this.saleProductRepository = repository;
        this.saleRepository = saleRepository;
    }
    
    public Iterable<SaleProduct> findAll(){
        return saleProductRepository.findAll();
    }
    
    public Optional<SaleProduct> findById(Integer saleProductId){
        return saleProductRepository.findById(saleProductId);
    }
    
    public SaleProduct save(SaleProductAddDto dto){
    	Sale sale = saleRepository.getReferenceById(dto.saleId);
    	SaleProduct SaleProduct = new SaleProduct(sale, dto.productId, dto.quantity, dto.unitPrice);
        return saleProductRepository.save(SaleProduct);
    }
    
    public SaleProduct update(Integer saleProductId, SaleProductUpdateDto dto) {
    	SaleProduct SaleProduct = saleProductRepository.getReferenceById(saleProductId);
        SaleProduct.setQuantity(dto.quantity);
        SaleProduct.setUnitPrice(dto.unitPrice);
        return saleProductRepository.save(SaleProduct);
    }
    
    public void deleteById(Integer saleProductId){
        saleProductRepository.deleteById(saleProductId);
    }

}
