package br.com.erudio.integrationstest.testcontainers;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstracIntegrationTest.Initializer.class)
public class AbstracIntegrationTest {

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:14.24")
                ;

        private static void startContainer() {
            Startables.deepStart(Stream.of(postgres)).join();
        }

        private Map<String,String> createConnectionConfiguration() {

        return  Map.of(
                        "spring.datasource.url",postgres.getJdbcUrl(),
                        "spring.datasource.username",postgres.getUsername(),
                        "spring.datasource.password",postgres.getPassword()


        );
        }

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            startContainer();
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            MapPropertySource testContainer = new MapPropertySource("testcontainer",
                    (Map)createConnectionConfiguration());
            environment.getPropertySources().addFirst(testContainer);

        }
    }
}
