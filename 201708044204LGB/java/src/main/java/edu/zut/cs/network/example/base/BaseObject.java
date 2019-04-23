package edu.zut.cs.network.example.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Base abstract class for objects. Child objects should implement toString(),
 * equals() and hashCode().
 *
 * @author <a href="mailto:ming616@gmail.com">Liu Xiaoming</a>
 */
public class BaseObject<PK extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3341516552625570448L;

	/**
	 * unique id for each object
	 */
	PK id;

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public PK getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public void setId(PK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
