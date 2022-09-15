@Entity
public class Student{
    @Id
    public int id;
    public String name;
    public String surname;
    public Date birthdate;
    public Genre genre;
    public long dni;
    public int cityId;
}

public enum Genre{
    "Masculino",
    "Femenino",
    "No sabe / no contesta"
}