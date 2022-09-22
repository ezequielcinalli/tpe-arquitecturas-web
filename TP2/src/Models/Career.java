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
    public int id;

    @OneToMany(mappedBy = "career")
    private List<StudentCareer> inscriptions;

    @Column
    public String name;
}