package org.zetta1985.framework.web;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.zetta1985.framework.validation.ValidationException;

/**
 * @author t_hara
 */
public class ValidationExceptionMapper implements
		ExceptionMapper<ValidationException> {

	/**
	 * @inheritDoc
	 */
	@Override
	public Response toResponse(ValidationException exception) {
		return null;
	}
}
