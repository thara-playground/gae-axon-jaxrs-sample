package org.zetta1985.blog.query.impl;

import org.slim3.datastore.Datastore;
import org.zetta1985.blog.query.BlogRepository;
import org.zetta1985.blog.query.BlogSetting;

/**
 * @author t_hara
 */
public class Slim3BlogRepository implements BlogRepository {

	@Override
	public BlogSetting getSetting() {
		return Datastore.query(BlogSetting.META).asSingle();
	}

}
