package org.zetta1985.dddsample.api;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.zetta1985.framework.domain.ValueObject;

/**
 * An itinerary consists of one or more legs.
 */
public class Leg implements ValueObject<Leg> {

	private static final long serialVersionUID = -3673056307702982635L;
	
	private Voyage voyage;
	private Location loadLocation;
	private Location unloadLocation;
	private Date loadTime;
	private Date unloadTime;

	public Leg(Voyage voyage, Location loadLocation, Location unloadLocation,
			Date loadTime, Date unloadTime) {
		Validate.noNullElements(new Object[] { voyage, loadLocation,
				unloadLocation, loadTime, unloadTime });

		this.voyage = voyage;
		this.loadLocation = loadLocation;
		this.unloadLocation = unloadLocation;
		this.loadTime = loadTime;
		this.unloadTime = unloadTime;
	}

	public Voyage voyage() {
		return voyage;
	}

	public Location loadLocation() {
		return loadLocation;
	}

	public Location unloadLocation() {
		return unloadLocation;
	}

	public Date loadTime() {
		return new Date(loadTime.getTime());
	}

	public Date unloadTime() {
		return new Date(unloadTime.getTime());
	}

	@Override
	public boolean sameValueAs(final Leg other) {
		return other != null
				&& new EqualsBuilder().append(this.voyage, other.voyage)
						.append(this.loadLocation, other.loadLocation).append(
								this.unloadLocation, other.unloadLocation)
						.append(this.loadTime, other.loadTime).append(
								this.unloadTime, other.unloadTime).isEquals();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Leg leg = (Leg) o;

		return sameValueAs(leg);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(voyage).append(loadLocation)
				.append(unloadLocation).append(loadTime).append(unloadTime)
				.toHashCode();
	}

}
