package org.zetta1985;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.joda.time.DateTime;
import org.zetta1985.addressbook.ContactModule;
import org.zetta1985.addressbook.web.ResourcesModule;
import org.zetta1985.framework.web.GuiceResteasyConfigContextListener;

import com.google.inject.Module;

/**
 * @author t_hara
 */
public class GuiceConfigContextListener extends
		GuiceResteasyConfigContextListener {

	private final Logger logger = Logger.getLogger("org.zetta1985");
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("contextInitialized start : " + new DateTime().toString("yyyy-MM-dd HH:mm:ss:SSS"));
		super.contextInitialized(event);
		logger.info("contextInitialized end : " + new DateTime().toString("yyyy-MM-dd HH:mm:ss:SSS"));
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	protected Module[] getModules(ServletContext context) {
		return new Module[]{
			new InfrastructureModule(),
			new CQRSModule(),
			new ContactModule(),
			new ResourcesModule()
		};
	}

}
