package sales.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import sales.dtos.DailySalesTotalDto;
import sales.dtos.ProductDto;
import sales.dtos.ProductMostSoldDto;
import sales.dtos.SaleSaveDto;
import sales.models.Sale;
import sales.repositories.SaleRepository;

@Service
public class SaleService {
	
	private static final String PRODUCTS_BASE_URL = "http://localhost:9002";
	
    @Autowired
    private final SaleRepository repository;
    
    @Autowired
    private final AuthService authService;

    public SaleService(SaleRepository repository, AuthService authService){
        this.repository = repository;
        this.authService = authService;
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
    
    public Iterable<DailySalesTotalDto> getDailySales(){
        return repository.getDailySales();
    }
    
    public ProductMostSoldDto getProductMostSold(){
    	var dto = repository.getProductsMostSold().get(0);
    	var internalToken = authService.getInternalJwtToken();
    	
    	Mono<ProductDto> productMono = WebClient
    		    .create(PRODUCTS_BASE_URL + "/products/" + dto.productId)
    		    .get()
    		    .header("Authorization", "Bearer " + internalToken)
    		    .retrieve()
    		    .bodyToMono(ProductDto.class);
    	
    	ProductDto product = productMono
    		    .share().block();
    	
    	dto.productName = product.name;
    	
    	return dto;
    }

}
