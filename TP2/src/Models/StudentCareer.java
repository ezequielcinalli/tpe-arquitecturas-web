@Entity
public class StudentCareer{
    @Id
    public int studentId;
    @Id
    public int careerId;
    public Date signUpDate;
    public Date graduationDate;
}