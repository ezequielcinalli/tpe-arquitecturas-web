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
}

