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