package sales.models;

import java.io.Serializable;
import java.util.Objects;

public class SaleProductId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Sale sale;

	private int productId;
    
    public SaleProductId() {
    }
    
    public SaleProductId(Sale sale, int productId) {
        this.sale = sale;
        this.productId = productId;
    }

	@Override
	public int hashCode() {
		return Objects.hash(sale, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleProductId other = (SaleProductId) obj;
		return sale == other.sale && productId == other.productId;
	}
    
}
