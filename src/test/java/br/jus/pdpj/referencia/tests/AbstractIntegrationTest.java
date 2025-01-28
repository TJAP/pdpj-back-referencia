package br.jus.pdpj.referencia.tests;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
@ActiveProfiles("test")
public class AbstractIntegrationTest {

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		public static final DockerImageName REDIS_IMAGE = DockerImageName.parse("redis:latest");

		static GenericContainer<?> redis =
				new GenericContainer<>(REDIS_IMAGE)
						.withExposedPorts(6379);

		@SuppressWarnings("rawtypes")
		static PostgreSQLContainer<?> postgres = new PostgreSQLContainer("postgres:latest")
				.withDatabaseName("pessoas")
				.withUsername("postgres")
				.withPassword("postgres");

		private static void startContainers() {
			Startables.deepStart(Stream.of(new GenericContainer[]{postgres, redis})).join();
		}

		private static Map<String, String> createConnectionConfiguration() {

			return Map.of(
					"spring.datasource.url", postgres.getJdbcUrl(),
					"spring.datasource.username", postgres.getUsername(),
					"spring.datasource.password", postgres.getPassword(),
					"spring.flyway.url", postgres.getJdbcUrl(),
					"spring.flyway.user", postgres.getUsername(),
					"spring.flyway.password", postgres.getPassword(),
					"spring.redis.host", redis.getHost(),
					"spring.redis.port", redis.getFirstMappedPort().toString());
		}

		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			startContainers();

			ConfigurableEnvironment environment = applicationContext.getEnvironment();

			@SuppressWarnings({"unchecked", "rawtypes"})
			MapPropertySource testcontainers = new MapPropertySource("testcontainers", (Map) createConnectionConfiguration());

			environment.getPropertySources().addFirst(testcontainers);
		}
	}

}
