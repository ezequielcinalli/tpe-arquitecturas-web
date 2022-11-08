package sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sales.dtos.BestSellingProductDto;
import sales.dtos.DailySalesDto;
import sales.models.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

	// TODO actual query
    @Query("SELECT new sales.dtos.DailySalesDto(s.customerId,s.date) FROM Sale s")
    public List<DailySalesDto> getDailySales();
    
    // TODO actual query
    @Query("SELECT 1")
    public Float getCustomerTotalAmountSpent(@Param("customerId") int customerId);
    
    // TODO actual query
    @Query("SELECT new sales.dtos.BestSellingProductDto(s.customerId,s.date) FROM Sale s")
    public BestSellingProductDto getBestSellingProduct();
    
}
