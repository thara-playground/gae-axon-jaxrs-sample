package org.zetta1985.blog.domain;

import java.util.UUID;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.StringAggregateIdentifier;
import org.axonframework.repository.Repository;
import org.zetta1985.blog.api.Article;
import org.zetta1985.blog.api.command.CreateBlogCommand;
import org.zetta1985.blog.api.command.PostArticleCommand;

/**
 * @author t_hara
 */
public class BlogCommandHandler {

	private Repository<Blog> repository;
	
	@CommandHandler
	public void handle(CreateBlogCommand command) {
		String blogId = UUID.randomUUID().toString();
		Blog blog = new Blog(new StringAggregateIdentifier(blogId), command.getTitle());
		repository.add(blog);
	}
	
	@CommandHandler
	public void handle(PostArticleCommand command) {
		String blogId = command.getBlogId();
		Blog blog = repository.load(new StringAggregateIdentifier(blogId));
		blog.postBlogEntry(command.getArticle());
	}
}
