package ua.anakin.model_09_SampleEntity;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Oliver Gierke
 */
@Entity
public class SampleEntity {

	@EmbeddedId
	protected SampleEntityPK id;

	protected SampleEntity() {

	}

	public SampleEntity(String first, String second) {

		this.id = new SampleEntityPK(first, second);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		if (!getClass().equals(obj.getClass())) {
			return false;
		}

		SampleEntity that = (SampleEntity) obj;

		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {

		return id.hashCode();
	}
}