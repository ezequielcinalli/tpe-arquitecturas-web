package Dtos;

import java.util.Date;

public class StudentInscriptionDto {
	
	private String fullName;
	private Date inscription;
	
	public StudentInscriptionDto(String fullName, Date inscription) {
		super();
		this.fullName = fullName;
		this.inscription = inscription;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Date getInscription() {
		return inscription;
	}
	
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}
	
}
