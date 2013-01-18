package org.zetta1985.blog.api.command;

import javax.validation.constraints.NotNull;

import org.zetta1985.framework.validation.Validation;

/**
 * @author t_hara
 */
@Validation
public class CreateBlogCommand {

	@NotNull
	private String title;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
