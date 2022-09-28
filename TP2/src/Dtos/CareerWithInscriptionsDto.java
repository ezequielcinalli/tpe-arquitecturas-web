package Dtos;

public class CareerWithInscriptionsDto {

	private String nameCareer;
	private long quantityInscriptions;
	

	public CareerWithInscriptionsDto(String nameCareer, long quantityInscriptions) {
		super();
		this.nameCareer = nameCareer;
		this.quantityInscriptions = quantityInscriptions;
	}

	public String getNameCareer() {
		return nameCareer;
	}

	public void setNameCareer(String nameCareer) {
		this.nameCareer = nameCareer;
	}

	public long getQuantityInscriptions() {
		return quantityInscriptions;
	}

	public void setQuantityInscriptions(int quantityInscriptions) {
		this.quantityInscriptions = quantityInscriptions;
	}
	
	@Override
	public String toString() {
		return "Career: " + nameCareer + " Quantity inscriptions:" + quantityInscriptions;
	}
}
