package Dtos;

import java.util.ArrayList;
import java.util.List;

public class CareerReportDto {

	private String nameCareer;
	private int year ;
	private List<String> enrolled;
	private List<String> graduated;
	
	public CareerReportDto(String nameCareer, int year) {
		super();
		this.nameCareer = nameCareer;
		this.year = year;
		this.enrolled = new ArrayList<String>();
		this.graduated = new ArrayList<String>();
	}
	
	public CareerReportDto(String nameCareer, int year, List<String> enrolled, List<String> graduated) {
		super();
		this.nameCareer = nameCareer;
		this.year = year;
		this.enrolled = enrolled;
		this.graduated = graduated;
	}
	
	public String getNameCareer() {
		return nameCareer;
	}
	
	public void setNameCareer(String nameCareer) {
		this.nameCareer = nameCareer;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<String> getEnrolled() {
		return enrolled;
	}
	
	public void setEnrolled(List<String> enrolled) {
		this.enrolled = enrolled;
	}
	
	public List<String> getGraduated() {
		return graduated;
	}
	
	public void setGraduated(List<String> graduated) {
		this.graduated = graduated;
	}

	@Override
	public String toString() {
		return "CareerReportDto{" +
				"nameCareer='" + nameCareer + '\'' +
				", year=" + year +
				", enrolled=" + enrolled +
				", graduated=" + graduated +
				'}';
	}
}
