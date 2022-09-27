package Dtos;

import java.util.List;

public class StudentsByCityDto {

	private int cityId;
	private String cityName;
	private List<StudentDto> students;
	
	public StudentsByCityDto(int cityId, String cityName, List<StudentDto> students) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.students = students;
	}
	
	public int getCityId() {
		return cityId;
	}
	
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public List<StudentDto> getStudents() {
		return students;
	}
	
	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}
	
}
