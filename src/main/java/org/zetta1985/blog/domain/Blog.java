package org.zetta1985.blog.domain;

import java.util.logging.Logger;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.zetta1985.blog.api.Article;
import org.zetta1985.blog.api.event.CreateBlogEvent;
import org.zetta1985.framework.axon.Aggregate;

/**
 * @author t_hara
 */
public class Blog extends Aggregate {

	private static final long serialVersionUID = -3638192556076550168L;
	
	private static final Logger logger = Logger.getLogger(Blog.class.getName());

	/**
	 * @param identifier
	 */
	public Blog(AggregateIdentifier identifier) {
		super(identifier);
	}
	
	public Blog(AggregateIdentifier identifier, String blogTitle) {
		super(identifier);
		apply(new CreateBlogEvent(identifier.asString(), blogTitle));
	}
	
	public void postBlogEntry(Article article) {
		
	}
	
	@EventHandler
	public void handle(CreateBlogEvent event) {
		logger.info("blog is created : " + event.getBlogTitle());
	}
}
