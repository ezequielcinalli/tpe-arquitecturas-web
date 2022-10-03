package Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class StudentCareer{
	
	@EmbeddedId
    private StudentCareerId key = new StudentCareerId();
	
	@MapsId("studentId")
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    public Student student;

	@MapsId("careerId")
    @ManyToOne
    @JoinColumn(name = "careerId", referencedColumnName = "id")
    public Career career;

    @Column(nullable = false)
    public Date signUpDate;

    @Column
    public Date graduationDate;
    
    public StudentCareer() {
    	super();
	}

	public StudentCareer(Student student, Career career, Date signUpDate, Date graduationDate) {
		super();
		this.student = student;
		this.career = career;
		this.signUpDate = signUpDate;
		this.graduationDate = graduationDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	@Override
	public String toString() {
		return "StudentCareer [carrerId=" + career + ", studentId=" + student + ", GraduationDate=" + graduationDate + "signUpDate=" + signUpDate +"]";
	}
    
}