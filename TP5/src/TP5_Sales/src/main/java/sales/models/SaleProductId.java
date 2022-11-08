package sales.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class SaleProductId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int studentId;

    private int careerId;
    
    public SaleProductId() {
    }
    
    public SaleProductId(int studentId, int careerId) {
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
		SaleProductId other = (SaleProductId) obj;
		return careerId == other.careerId && studentId == other.studentId;
	}
    
}
