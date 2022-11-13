package sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sales.models.SaleProduct;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {
}
