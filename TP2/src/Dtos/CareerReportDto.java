package Dtos;

import java.util.List;

public class CareerReportDto {

	private String name;
	private List<StudentInscriptionDto> inscriptions;
	private List<StudentGraduationDto> graduations;
	
	public CareerReportDto(String name, List<StudentInscriptionDto> inscriptions,
			List<StudentGraduationDto> graduations) {
		super();
		this.name = name;
		this.inscriptions = inscriptions;
		this.graduations = graduations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentInscriptionDto> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<StudentInscriptionDto> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public List<StudentGraduationDto> getGraduations() {
		return graduations;
	}

	public void setGraduations(List<StudentGraduationDto> graduations) {
		this.graduations = graduations;
	}
	
}
