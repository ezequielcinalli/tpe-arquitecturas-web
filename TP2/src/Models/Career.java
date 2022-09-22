package Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Career{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "career")
    private List<StudentCareer> inscriptions;
    
    public Career() {
    	super();
	}

	public Career(List<StudentCareer> inscriptions, String name) {
		super();
		this.inscriptions = inscriptions;
		this.name = name;
	}

	public List<StudentCareer> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<StudentCareer> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
    
}