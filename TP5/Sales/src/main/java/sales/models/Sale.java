package sales.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sale {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "sale")
    @JsonIgnore
    private List<SaleProduct> saleProducts;
    
    public Sale() {
    	super();
	}
    
    public Sale(int customerId, Date date) {
		super();
		this.customerId = customerId;
		this.date = date;
	}

	public Sale(int customerId, Date date, List<SaleProduct> saleProducts) {
		super();
		this.customerId = customerId;
		this.date = date;
		this.saleProducts = saleProducts;
	}

	public int getId() {
		return id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<SaleProduct> getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(List<SaleProduct> saleProducts) {
		this.saleProducts = saleProducts;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", customerId=" + customerId + ", date=" + date + ", saleProducts=" + saleProducts
				+ "]";
	}
	
}
