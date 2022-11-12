package sales.models;

import javax.persistence.*;

@Entity
public class SaleProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false) 
    @JoinColumn(nullable = false)
    private Sale sale;

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
