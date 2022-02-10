package tech.profitware.conceptualart.config;

import org.apache.camel.CamelContext;

public interface CDIConfiguration {
	public CamelContext configureCamelContext(CamelContext camelContext);
}
