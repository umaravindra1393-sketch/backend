package com.zyndex.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ZyndexSpringBackendApplicationTests {
	private final AppProperties properties;

	ZyndexSpringBackendApplicationTests(AppProperties properties) {
		this.properties = properties;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void loadsDefaultAccountConfig() {
		org.assertj.core.api.Assertions.assertThat(properties.mainAdminEmail()).isNotBlank();
		org.assertj.core.api.Assertions.assertThat(properties.defaultUserEmail()).isNotBlank();
	}

}
