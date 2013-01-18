package org.zetta1985.blog.api.command;

/**
 * @author t_hara
 */
public abstract class AbstractArticleCommand {

	private String blogId;

	/**
	 * @return the blogTitle
	 */
	public String getBlogId() {
		return blogId;
	}

	/**
	 * @param blogTitle the blogTitle to set
	 */
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	
	
}
