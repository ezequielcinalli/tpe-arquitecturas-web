package sales.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(SaleProductId.class) 
public class SaleProduct {
	
	@Id
	@ManyToOne(optional = false) 
    @JoinColumn(nullable = false)
    private Sale sale;

	@Id
    @Column(nullable = false)
	private int productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private float unitPrice;
    
    public SaleProduct() {
    	super();
	}

	public SaleProduct(Sale sale, int productId, int quantity, float unitPrice) {
		super();
		this.sale = sale;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
