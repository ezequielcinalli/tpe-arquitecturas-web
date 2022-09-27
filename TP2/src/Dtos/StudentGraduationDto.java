package Dtos;

import java.util.Date;

public class StudentGraduationDto {

	private String fullName;
	private Date graduation;
	
	public StudentGraduationDto(String fullName, Date graduation) {
		super();
		this.fullName = fullName;
		this.graduation = graduation;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Date getGraduation() {
		return graduation;
	}
	
	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}
	
}
