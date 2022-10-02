package Models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.derby.iapi.services.locks.C_LockFactory;

@Entity
public class Student{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false)
    private Genre genre;

    @Column(nullable = false)
    private long dni;

    @ManyToOne
    @JoinColumn(name="cityId",referencedColumnName="id",nullable = false)
    private City city;

    @OneToMany(mappedBy = "student")
    private List<StudentCareer> careers;
    
    public Student() {
    	super();
	}

	public Student(String name, String surname, Date birthdate, Genre genre, long dni, City city,
			List<StudentCareer> careers) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.genre = genre;
		this.dni = dni;
		this.city = city;
		this.careers = careers;
	}
	
	

	public Student(String name, String surname, Date birthdate, Genre genre, long dni, City city) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.genre = genre;
		this.dni = dni;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public City getcity() {
		return city;
	}

	public void setcity(City city) {
		this.city = city;
	}

	public List<StudentCareer> getCareers() {
		return careers;
	}

	public void setCareers(List<StudentCareer> careers) {
		this.careers = careers;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", genre="
				+ genre + ", dni=" + dni + ", city=" + city + "]";
	}
	
	
    
}

