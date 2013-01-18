package org.zetta1985.dddsample.api;

import org.apache.commons.lang.Validate;
import org.zetta1985.framework.domain.ValueObject;

/**
 * @author t_hara
 * 
 */
public class TrackingId implements ValueObject<TrackingId> {

	private static final long serialVersionUID = 2598840683162868165L;

	private final String id;

	/**
	 * @param id
	 */
	public TrackingId(String id) {
		super();
		Validate.notNull(id);
		this.id = id;
	}
	
	public String idString() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TrackingId other = (TrackingId) o;

		return sameValueAs(other);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean sameValueAs(TrackingId other) {
		return other != null && this.id.equals(other.id);
	}

	@Override
	public String toString() {
		return id;
	}

}
