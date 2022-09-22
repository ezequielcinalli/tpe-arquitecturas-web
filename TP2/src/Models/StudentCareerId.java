package Models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class StudentCareerId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public int studentId;

    public int careerId;
    
    public StudentCareerId() {
    }
    
    public StudentCareerId(int studentId, int careerId) {
        this.studentId = studentId;
        this.careerId = careerId;
    }

	@Override
	public int hashCode() {
		return Objects.hash(careerId, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCareerId other = (StudentCareerId) obj;
		return careerId == other.careerId && studentId == other.studentId;
	}
    
}
