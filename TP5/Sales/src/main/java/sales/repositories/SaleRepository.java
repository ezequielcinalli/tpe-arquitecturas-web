package sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sales.models.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

	@Query("SELECT SUM(sp.quantity * sp.unitPrice) FROM Sale s JOIN SaleProduct sp ON s.id = sp.sale.id WHERE s.customerId = :customerId GROUP BY s.customerId")
    public Float getCustomerTotalAmountSpent(@Param("customerId") int customerId);
	
	// TODO actual query
    //@Query("SELECT new sales.dtos.DailySalesDto(s.customerId,s.date) FROM Sale s")
    //public List<DailySalesDto> getDailySales();
    
    // TODO actual query
    //@Query("SELECT new sales.dtos.BestSellingProductDto(s.customerId,s.date) FROM Sale s")
    //public BestSellingProductDto getBestSellingProduct();
    
}
