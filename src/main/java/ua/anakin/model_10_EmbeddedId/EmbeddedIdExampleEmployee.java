package ua.anakin.model_10_EmbeddedId;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Thomas Darimont
 */
@Entity
public class EmbeddedIdExampleEmployee {

	@EmbeddedId EmbeddedIdExampleEmployeePK employeePk;

	@MapsId("departmentId")//
	@ManyToOne(cascade = CascadeType.ALL)//
	EmbeddedIdExampleDepartment departmentt;

	public EmbeddedIdExampleEmployeePK getEmployeePk() {
		return employeePk;
	}

	public void setEmployeePk(EmbeddedIdExampleEmployeePK employeePk) {
		this.employeePk = employeePk;
	}

	public EmbeddedIdExampleDepartment getDepartment() {
		return departmentt;
	}

	public void setDepartment(EmbeddedIdExampleDepartment department) {
		this.departmentt = department;
	}
}