package org.zetta1985.dddsample.api;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.zetta1985.framework.domain.ValueObject;

/**
 * An itinerary.
 * 
 */
public class Itinerary implements ValueObject<Itinerary> {

	/**  */
	private static final long serialVersionUID = -2728224287450617698L;

	private List<Leg> legs = Collections.emptyList();

	static final Itinerary EMPTY_ITINERARY = new Itinerary();
	
	private static final Date END_OF_DAYS = new Date(Long.MAX_VALUE);

	private Itinerary() {
	}
	
	/**
	 * Constructor.
	 * 
	 * @param legs
	 *            List of legs for this itinerary.
	 */
	public Itinerary(final List<Leg> legs) {
		Validate.notEmpty(legs);
		Validate.noNullElements(legs);

		this.legs = legs;
	}

	/**
	 * @return the legs of this itinerary, as an <b>immutable</b> list.
	 */
	public List<Leg> legs() {
		return Collections.unmodifiableList(legs);
	}

	/**
	 * @return The initial departure location.
	 */
	Location initialDepartureLocation() {
		if (legs.isEmpty()) {
			return Location.UNKNOWN;
		} else {
			return legs.get(0).loadLocation();
		}
	}

	/**
	 * @return The final arrival location.
	 */
	Location finalArrivalLocation() {
		if (legs.isEmpty()) {
			return Location.UNKNOWN;
		} else {
			return lastLeg().unloadLocation();
		}
	}

	/**
	 * @return Date when cargo arrives at final destination.
	 */
	Date finalArrivalDate() {
		final Leg lastLeg = lastLeg();

		if (lastLeg == null) {
			return new Date(END_OF_DAYS.getTime());
		} else {
			return new Date(lastLeg.unloadTime().getTime());
		}
	}

	/**
	 * @return The last leg on the itinerary.
	 */
	Leg lastLeg() {
		if (legs.isEmpty()) {
			return null;
		} else {
			return legs.get(legs.size() - 1);
		}
	}

	/**
	 * @param other
	 *            itinerary to compare
	 * @return <code>true</code> if the legs in this and the other itinerary are
	 *         all equal.
	 */
	@Override
	public boolean sameValueAs(final Itinerary other) {
		return other != null && legs.equals(other.legs);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Itinerary itinerary = (Itinerary) o;

		return sameValueAs(itinerary);
	}

	@Override
	public int hashCode() {
		return legs.hashCode();
	}

}
