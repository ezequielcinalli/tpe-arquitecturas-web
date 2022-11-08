package sales.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class SaleProduct {
	
	@EmbeddedId
    private SaleProductId key = new SaleProductId();
	
	@MapsId("saleId")
    @ManyToOne
    @JoinColumn(name = "saleId", referencedColumnName = "id")
    private Sale sale;

	@MapsId("productId")
	@Column(name = "careerId")
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

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "SaleProduct [sale=" + sale + ", productId=" + productId + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + "]";
	}
	
}
