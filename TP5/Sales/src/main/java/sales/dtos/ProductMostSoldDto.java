package sales.dtos;

public class ProductMostSoldDto {
	
	public int productId;
	
	public long quantity;

	public ProductMostSoldDto(int productId, long quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	
}
