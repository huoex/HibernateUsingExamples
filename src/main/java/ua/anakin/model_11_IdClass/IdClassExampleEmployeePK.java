package ua.anakin.model_11_IdClass;
import java.io.Serializable;

/**
 * @author Thomas Darimont
 */
public class IdClassExampleEmployeePK implements Serializable {
	private static final long serialVersionUID = 1L;

	private long empId;
	private long department;

	public IdClassExampleEmployeePK() {}

	public IdClassExampleEmployeePK(long empId, long department) {
		this.empId = empId;
		this.department = department;
	}

	public long getEmpId() {
		return this.empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getDepartment() {
		return this.department;
	}

	public void setDepartment(long department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (department ^ (department >>> 32));
		result = prime * result + (int) (empId ^ (empId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		IdClassExampleEmployeePK other = (IdClassExampleEmployeePK) obj;
		if (department != other.department) {
			return false;
		}
		if (empId != other.empId) {
			return false;
		}
		return true;
	}
}