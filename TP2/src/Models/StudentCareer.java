@Entity
public class StudentCareer{
    @Id
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    public Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "careerId", referencedColumnName = "id")
    public Career career;

    @Column
    public Date signUpDate;

    @Column
    public Date graduationDate;
}