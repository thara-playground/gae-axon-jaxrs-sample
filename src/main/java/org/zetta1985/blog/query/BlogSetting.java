package org.zetta1985.blog.query;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * @author t_hara
 */
@Model(schemaVersion = 1)
public class BlogSetting implements Serializable{

	public static final BlogSettingMeta META = BlogSettingMeta.get();
	
	public static Key createKey(String blogId) {
		return Datastore.createKey(META, blogId);
	}
	
	private static final long serialVersionUID = -3496231651800687167L;

	@Attribute(primaryKey = true)
    private Key key;
	@Attribute(unindexed = true)
	private String title;
    
	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}

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
