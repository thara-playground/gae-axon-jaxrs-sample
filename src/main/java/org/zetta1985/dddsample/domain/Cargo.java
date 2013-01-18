package org.zetta1985.dddsample.domain;

import org.axonframework.domain.AggregateIdentifier;
import org.zetta1985.framework.axon.Aggregate;

/**
 * @author t_hara
 *
 */
public class Cargo extends Aggregate {

	/**  */
	private static final long serialVersionUID = -1574948186830674538L;

	/**
	 * @param identifier
	 */
	public Cargo(AggregateIdentifier identifier) {
		super(identifier);
	}
}
