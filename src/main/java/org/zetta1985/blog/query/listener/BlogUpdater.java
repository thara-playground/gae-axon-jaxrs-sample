package org.zetta1985.blog.query.listener;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.slim3.datastore.GlobalTransaction;
import org.zetta1985.blog.api.event.CreateBlogEvent;
import org.zetta1985.blog.query.BlogSetting;
import org.zetta1985.framework.transaction.Slim3Session;
import org.zetta1985.framework.transaction.Slim3SessionManager;

import com.google.appengine.api.datastore.Key;
import com.google.inject.Inject;

/**
 * @author t_hara
 */
public class BlogUpdater {

	@Inject
	Slim3SessionManager sessionManager;
	
	@EventHandler
	public void handle(CreateBlogEvent event) {
		Slim3Session session = sessionManager.currentSession();
		GlobalTransaction gtx = session.currentTransaction();

		Key key = BlogSetting.createKey(event.getBlogId());
		BlogSetting setting = gtx.getOrNull(BlogSetting.META, key);
		if (setting == null) {
			setting = new BlogSetting();
		}
		
		setting.setTitle(event.getBlogTitle());
		session.put(setting);
	}
}
