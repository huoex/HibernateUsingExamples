package ua.anakin.model_10_EmbeddedId;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Thomas Darimont
 */
@Embeddable
public class EmbeddedIdExampleEmployeePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false) private Long employeeId;

	@Column(nullable = false) private Long departmentId;

	public EmbeddedIdExampleEmployeePK() {}

	public EmbeddedIdExampleEmployeePK(Long employeeId, Long departmentId) {
		this.employeeId = employeeId;
		this.departmentId = departmentId;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (departmentId ^ (departmentId >>> 32));
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmbeddedIdExampleEmployeePK other = (EmbeddedIdExampleEmployeePK) obj;
		if (departmentId != other.departmentId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}
}