package org.zetta1985.dddsample.api;

import org.zetta1985.framework.domain.ValueObject;

/**
 * @author t_hara
 * 
 */
public class VoyageNumber implements ValueObject<VoyageNumber> {

	private static final long serialVersionUID = 7486999428154765539L;
	
	private final String number;

	/**
	 * @param number
	 */
	public VoyageNumber(String number) {
		super();
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || !(o instanceof VoyageNumber)) return false;

		VoyageNumber other = (VoyageNumber) o;
		return sameValueAs(other);
	}

	@Override
	public int hashCode() {
		return number.hashCode();
	}

	@Override
	public boolean sameValueAs(VoyageNumber other) {
		return other != null && this.number.equals(other.number);
	}

	@Override
	public String toString() {
		return number;
	}

	public String idString() {
		return number;
	}
}
