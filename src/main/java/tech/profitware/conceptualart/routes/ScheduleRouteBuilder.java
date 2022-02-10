package tech.profitware.conceptualart.routes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import tech.profitware.conceptualart.config.CDIConfiguration;

@ApplicationScoped
public class ScheduleRouteBuilder extends RouteBuilder {
	@Inject
	CamelContext camelContext;

	@Inject
	@Named("quartzConfiguration")
	CDIConfiguration quartzConfiguration;

	@Override
	public void configure() throws Exception {
		quartzConfiguration.configureCamelContext(camelContext);

		from("stub:quartz2://scheduler?trigger.repeatInterval=3000")
				.setBody(simple("Hello from Quartz on ${headers.fireTime}!"))
				.to("stub:log:INFO")
				;
	}
}
