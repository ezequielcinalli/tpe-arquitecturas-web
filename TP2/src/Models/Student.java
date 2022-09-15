@Entity
public class Student{
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

public enum Genre{
    "Masculino",
    "Femenino",
    "No sabe / no contesta"
}