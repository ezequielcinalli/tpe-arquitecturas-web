package Dtos;

public class CareerWithInscriptionsDto {

	private String nameCareer;
	private int quantityInscriptions;
	

	public CareerWithInscriptionsDto(String nameCareer, int quantityInscriptions) {
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

	public int getQuantityInscriptions() {
		return quantityInscriptions;
	}

	public void setQuantityInscriptions(int quantityInscriptions) {
		this.quantityInscriptions = quantityInscriptions;
	}
	
}
