package org.zetta1985.dddsample.api;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.zetta1985.framework.domain.ValueObject;

/**
 * A voyage schedule.
 * 
 */
public class Schedule implements ValueObject<Schedule> {

	private static final long serialVersionUID = 8010648913915258692L;

	private List<CarrierMovement> carrierMovements = Collections.emptyList();

	public static final Schedule EMPTY = new Schedule();
	
	Schedule() {
	}

	Schedule(List<CarrierMovement> carrierMovements) {
		Validate.notNull(carrierMovements);
		Validate.noNullElements(carrierMovements);
		Validate.notEmpty(carrierMovements);

		this.carrierMovements = carrierMovements;
	}

	/**
	 * @return Carrier movements.
	 */
	public List<CarrierMovement> carrierMovements() {
		return Collections.unmodifiableList(carrierMovements);
	}

	@Override
	public boolean sameValueAs(final Schedule other) {
		return other != null
				&& this.carrierMovements.equals(other.carrierMovements);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Schedule that = (Schedule) o;

		return sameValueAs(that);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.carrierMovements).toHashCode();
	}


}
