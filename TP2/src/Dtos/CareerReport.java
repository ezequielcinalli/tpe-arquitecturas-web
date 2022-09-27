package Dtos;

import java.util.LinkedList;
import java.util.Map;

import Models.Student;
import Models.StudentCareer;

public class CareerReport {
	private int id;
    private String name;
    private Map<Integer, LinkedList<Student>> inscriptions;
    private Map<Integer, LinkedList<Student>> graduations;
    
    public CareerReport(int id, String name) {
    	this.id = id;
    	this.name = name;
	}
    
    @SuppressWarnings("deprecation")
	public void addInscription(StudentCareer studentCareer) {
    	if(this.inscriptions.containsKey(studentCareer.signUpDate.getYear())) {
    		LinkedList<Student> list = this.inscriptions.get(studentCareer.signUpDate.getYear());
    		list.add(studentCareer.student);
    	}
    	else {
    		LinkedList<Student> list = new LinkedList<Student>();
    		list.add(studentCareer.student);
    		this.inscriptions.put(studentCareer.signUpDate.getYear(), list);
    	}
	}
    
    @SuppressWarnings("deprecation")
	public void addGraduation(StudentCareer studentCareer) {
    	if(studentCareer.graduationDate == null) return;
    	if(this.graduations.containsKey(studentCareer.graduationDate.getYear())) {
    		LinkedList<Student> list = this.graduations.get(studentCareer.graduationDate.getYear());
    		list.add(studentCareer.student);
    	}
    	else {
    		LinkedList<Student> list = new LinkedList<Student>();
    		list.add(studentCareer.student);
    		this.graduations.put(studentCareer.graduationDate.getYear(), list);
    	}
	}
}
