package Dtos;

import java.util.List;

public class StudentsFromCareerByYearDto {

	private int year;
	private List<StudentDto> enrolled;
	private List<StudentDto> graduated;
	
	public StudentsFromCareerByYearDto(int year, List<StudentDto> inscriptos, List<StudentDto> graduados) {
		super();
		this.year = year;
		this.enrolled = inscriptos;
		this.graduated = graduados;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<StudentDto> getInscriptos() {
		return enrolled;
	}

	public void setInscriptos(List<StudentDto> inscriptos) {
		this.enrolled = inscriptos;
	}

	public List<StudentDto> getGraduados() {
		return graduated;
	}

	public void setGraduados(List<StudentDto> graduados) {
		this.graduated = graduados;
	}
	
}
