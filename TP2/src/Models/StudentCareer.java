package Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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