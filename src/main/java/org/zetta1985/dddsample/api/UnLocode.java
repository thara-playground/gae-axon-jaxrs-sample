package org.zetta1985.dddsample.api;

import java.util.regex.Pattern;

import org.apache.commons.lang.Validate;
import org.zetta1985.framework.domain.ValueObject;

/**
 * @author t_hara
 * 
 */
public class UnLocode implements ValueObject<UnLocode> {

	private static final long serialVersionUID = -3111429998518523137L;

	static final Pattern VALID_PATTERN = Pattern
			.compile("[a-zA-Z]{2}[a-zA-Z2-9]{3}");

	private final String unlocode;

	/**
	 * @param unlocode
	 */
	public UnLocode(String countryAndLocation) {
		super();
		Validate.notNull(countryAndLocation,
				"Country and location may not be null");
		Validate.isTrue(VALID_PATTERN.matcher(countryAndLocation).matches(),
				countryAndLocation
						+ " is not a valid UN/LOCODE (does not match pattern)");

		this.unlocode = countryAndLocation.toUpperCase();
	}

	/**
	 * @return country code and location code concatenated, always upper case.
	 */
	public String idString() {
		return unlocode;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UnLocode other = (UnLocode) o;

		return sameValueAs(other);
	}

	@Override
	public int hashCode() {
		return unlocode.hashCode();
	}

	@Override
	public boolean sameValueAs(UnLocode other) {
		return other != null && this.unlocode.equals(other.unlocode);
	}

	@Override
	public String toString() {
		return idString();
	}
}
