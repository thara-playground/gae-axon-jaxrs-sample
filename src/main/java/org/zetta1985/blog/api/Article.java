package org.zetta1985.blog.api;

import javax.validation.constraints.NotNull;

import org.zetta1985.framework.validation.Validation;

/**
 * @author t_hara
 */
@Validation
public class Article {

	@NotNull
	private String title;
	
	@NotNull
	private String body;

	/**
	 * @param title
	 * @param body
	 */
	public Article(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
}
