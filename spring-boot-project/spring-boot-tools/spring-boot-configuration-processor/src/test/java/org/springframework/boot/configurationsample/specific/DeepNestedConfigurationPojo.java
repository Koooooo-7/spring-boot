package org.springframework.boot.configurationsample.specific;

import org.springframework.boot.configurationsample.NestedConfigurationProperty;

public class DeepNestedConfigurationPojo {

	private String name;

	@NestedConfigurationProperty
	private SimplePojo nested;

	@NestedConfigurationProperty
	private SimplePojo integration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SimplePojo getNested() {
		return nested;
	}

	public void setNested(SimplePojo nested) {
		this.nested = nested;
	}

	public SimplePojo getIntegration() {
		return integration;
	}

	public void setIntegration(SimplePojo integration) {
		this.integration = integration;
	}
}
