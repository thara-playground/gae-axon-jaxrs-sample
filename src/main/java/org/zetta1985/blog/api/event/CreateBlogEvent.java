package org.zetta1985.blog.api.event;

import java.util.Date;

import org.axonframework.domain.DomainEvent;

/**
 * @author t_hara
 */
public class CreateBlogEvent extends DomainEvent{

	private static final long serialVersionUID = -7578840245933561758L;

	private long since;
	
	private String blogId;
	
	private String blogTitle;

	/**
	 * @param since
	 * @param blogTitle
	 */
	public CreateBlogEvent(String blogId, String blogTitle) {
		super();
		this.since = new Date().getTime();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
	}

	/**
	 * @return the since
	 */
	public long getSince() {
		return since;
	}
	
	/**
	 * @return the blogId
	 */
	public String getBlogId() {
		return blogId;
	}

	/**
	 * @return the blogTitle
	 */
	public String getBlogTitle() {
		return blogTitle;
	}
}
