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
	 enum Genre{
	    Masculino,
	    Femenino,
	    NosabeNocontesta,
	 };

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;

    @Column
    public String name;

    @Column
    public String surname;

    @Column
    public Date birthdate;

    @Column
    public Genre genre;

    @Column
    public long dni;

    @ManyToOne
    @JoinColumn(name="id")
    public City cityId;

    @OneToMany(mappedBy = "student")
    private List<StudentCareer> careers;
    
    public Student() {
    	super();
	}

	public Student(String name, String surname, Date birthdate, Genre genre, long dni, City cityId,
			List<StudentCareer> careers) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.genre = genre;
		this.dni = dni;
		this.cityId = cityId;
		this.careers = careers;
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

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
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
    
}

