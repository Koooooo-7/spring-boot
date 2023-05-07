package org.springframework.boot.configurationsample.specific;

import org.springframework.boot.configurationsample.ConfigurationProperties;
import org.springframework.boot.configurationsample.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "nested")
public class DeepNestedConfigurationProperties {

	private String property;

	@NestedConfigurationProperty
	private DeepNestedConfigurationPojo nestedConfiguration = new DeepNestedConfigurationPojo();

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public DeepNestedConfigurationPojo getNestedConfiguration() {
		return nestedConfiguration;
	}

	public void setNestedConfiguration(DeepNestedConfigurationPojo nestedConfiguration) {
		this.nestedConfiguration = nestedConfiguration;
	}
}
