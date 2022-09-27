package Dtos;

import java.util.List;

public class CareerReportDto {

	private String name;
	private List<StudentsFromCareerByYearDto> studentsByYear;
	
	public CareerReportDto(String name, List<StudentsFromCareerByYearDto> studentsByYear) {
		super();
		this.name = name;
		this.studentsByYear = studentsByYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentsFromCareerByYearDto> getStudentsByYear() {
		return studentsByYear;
	}

	public void setStudentsByYear(List<StudentsFromCareerByYearDto> studentsByYear) {
		this.studentsByYear = studentsByYear;
	}
	
}
