package org.zetta1985.blog.api.command;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.zetta1985.blog.api.Article;

/**
 * @author t_hara
 */
public class PostArticleCommand extends AbstractArticleCommand{

	private Date postedDate;

	@NotNull
	private Article article;

	/**
	 * @return the postedDate
	 */
	public Date getPostedDate() {
		return postedDate;
	}

	/**
	 * @param postedDate the postedDate to set
	 */
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
