package org.zetta1985.addressbook.query;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * @author t_hara
 *
 */
@Model(schemaVersion = 1)
public class ContactEntry implements Serializable{
	
	public static final ContactEntryMeta CONTACT = ContactEntryMeta.get();
	
	public static Key createKey(String identifier) {
		return Datastore.createKey(CONTACT, identifier);
	}
	
	private static final long serialVersionUID = 8597617121201695170L;

	@Attribute(primaryKey = true)
	Key key;

    @NotNull
    @Size(min = 3)
    private String name;


	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return this.key.getName();
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.key = ContactEntry.createKey(identifier);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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
}
