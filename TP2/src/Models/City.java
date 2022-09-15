@Entity
public class City{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;

    @Column
    public String name;
}