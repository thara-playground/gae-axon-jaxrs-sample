package org.zetta1985.framework.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jboss.resteasy.plugins.guice.ModuleProcessor;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.jboss.resteasy.spi.Registry;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.google.inject.Module;
import com.google.inject.Stage;

/**
 * @author t_hara
 */
public abstract class GuiceResteasyConfigContextListener extends ResteasyBootstrap implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		Registry registry = (Registry) context.getAttribute(Registry.class.getName());
		ResteasyProviderFactory providerFactory = (ResteasyProviderFactory) context
				.getAttribute(ResteasyProviderFactory.class.getName());
		ModuleProcessor processor = new ModuleProcessor(registry,providerFactory);
		Module[] modules = getModules(context);
		Stage stage = getStage(context);
		if (stage == null) {
			processor.process(modules);
		} else {
			processor.process(stage, modules);
		}
	}

	private Stage getStage(ServletContext context) {
		String stageAsString = context
				.getInitParameter("resteasy.guice.stage");
		if (stageAsString == null) {
			return null;
		}
		try {
			return Stage.valueOf(stageAsString.trim());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"Injector stage is not defined properly. "
							+ stageAsString
							+ " is wrong value."
							+ " Possible values are PRODUCTION, DEVELOPMENT, TOOL.");
		}
	}

	protected abstract Module[] getModules(ServletContext context);

	public void contextDestroyed(ServletContextEvent event) {
	}
}
