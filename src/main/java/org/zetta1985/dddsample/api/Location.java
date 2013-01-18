package org.zetta1985.dddsample.api;

import org.apache.commons.lang.Validate;
import org.zetta1985.framework.domain.Entity;

/**
 * @author t_hara
 * 
 */
public class Location implements Entity<Location> {

	private static final long serialVersionUID = -3775795059032194548L;

	/**
	 * Special Location object that marks an unknown location.
	 */
	public static final Location UNKNOWN = new Location(new UnLocode("XXXXX"),
			"Unknown location");

	private UnLocode unLocode;
	private String name;

	/**
	 * @param unLocode
	 * @param name
	 */
	public Location(UnLocode unLocode, String name) {
		super();
	    Validate.notNull(unLocode);
	    Validate.notNull(name);
	    
		this.unLocode = unLocode;
		this.name = name;
	}

	/**
	 * @return UN Locode for this location.
	 */
	public UnLocode unLocode() {
		return unLocode;
	}

	/**
	 * @return Actual name of this location, e.g. "Stockholm".
	 */
	public String name() {
		return name;
	}

	/**
	 * @param object
	 *            to compare
	 * @return Since this is an entiy this will be true iff UN locodes are
	 *         equal.
	 */
	@Override
	public boolean equals(final Object object) {
		if (this == object) return true;
		if (object == null || !(object instanceof Location)) return false;
		
		Location other = (Location) object;
		return sameIdentityAs(other);
	}

	@Override
	public boolean sameIdentityAs(final Location other) {
		return this.unLocode.sameValueAs(other.unLocode);
	}

	/**
	 * @return Hash code of UN locode.
	 */
	@Override
	public int hashCode() {
		return unLocode.hashCode();
	}

	@Override
	public String toString() {
		return name + " [" + unLocode + "]";
	}

}
