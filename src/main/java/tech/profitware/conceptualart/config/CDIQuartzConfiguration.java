package tech.profitware.conceptualart.config;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.CamelContext;
import org.apache.camel.component.quartz.QuartzComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Named("quartzConfiguration")
public class CDIQuartzConfiguration extends Properties implements CDIConfiguration {
	private static final Logger LOG = LoggerFactory.getLogger(CDIQuartzConfiguration.class);

	@PostConstruct
	void customize() {
		setProperty("org.quartz.scheduler.instanceName", "DefaultQuartzScheduler");
		setProperty("org.quartz.scheduler.instanceId", "AUTO");

		setProperty("org.quartz.threadPool.threadCount", "5");
		setProperty("org.quartz.threadPool.threadPriority", "3");

		setProperty("startDelayedSeconds", "5");

		LOG.info("Quartz Initialized!");
	}

	@Override
	public CamelContext configureCamelContext(CamelContext camelContext) {
		QuartzComponent quartzComponent = new QuartzComponent(camelContext);
		quartzComponent.setProperties(this);
		camelContext.addComponent("quartz2", quartzComponent);

		return camelContext;
	}
}
