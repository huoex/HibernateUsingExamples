package ua.anakin.model_09_SampleEntity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class SampleEntityPK implements Serializable {

	private static final long serialVersionUID = 231060947L;

	@Column(nullable = false)
	private String first;
	@Column(nullable = false)
	private String second;

	public SampleEntityPK() {

		this.first = null;
		this.second = null;
	}

	public SampleEntityPK(String first, String second) {

		this.first = first;
		this.second = second;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		SampleEntityPK that = (SampleEntityPK) obj;

		return this.first.equals(that.first) && this.second.equals(that.second);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		int result = 17;
		result += 31 * first.hashCode();
		result += 31 * second.hashCode();
		return result;
	}
}