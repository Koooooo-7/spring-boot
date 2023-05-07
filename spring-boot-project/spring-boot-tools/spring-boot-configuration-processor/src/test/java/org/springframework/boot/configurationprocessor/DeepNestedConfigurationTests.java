package org.springframework.boot.configurationprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.configurationprocessor.metadata.ConfigurationMetadata;
import org.springframework.boot.configurationprocessor.metadata.Metadata;
import org.springframework.boot.configurationsample.specific.DeepNestedConfigurationPojo;
import org.springframework.boot.configurationsample.specific.DeepNestedConfigurationProperties;
import org.springframework.boot.configurationsample.specific.SimplePojo;

import static org.assertj.core.api.Assertions.assertThat;

public class DeepNestedConfigurationTests extends AbstractMetadataGenerationTests {
	@Test
	void deepNestedConfiguration() {
		final ConfigurationMetadata metadata = compile(DeepNestedConfigurationProperties.class);
		assertThat(metadata).has(Metadata.withGroup("nested").fromSource(DeepNestedConfigurationProperties.class));
		assertThat(metadata).has(Metadata.withGroup("nested.nested-configuration")
				.ofType(DeepNestedConfigurationPojo.class));

		assertThat(metadata).has(Metadata.withGroup("nested.nested-configuration.nested")
				.ofType(SimplePojo.class));
		assertThat(metadata).has(Metadata.withProperty("nested.nested-configuration.nested.value")
				.ofType(Integer.class));

		assertThat(metadata).has(Metadata.withGroup("nested.nested-configuration.integration")
				.ofType(SimplePojo.class));
		assertThat(metadata).has(Metadata.withProperty("nested.nested-configuration.integration.value")
				.ofType(Integer.class));
		assertThat(metadata.getItems()).hasSize(8);
	}
}
