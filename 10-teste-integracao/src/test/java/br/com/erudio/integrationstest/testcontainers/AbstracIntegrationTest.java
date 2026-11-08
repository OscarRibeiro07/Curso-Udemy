package br.com.erudio.integrationstest.testcontainers;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstracIntegrationTest.Initializer.class)
public class AbstracIntegrationTest {

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:14.24-trixie")
                ;

        private static void startContainer() {
            Startables.deepStart(Stream.of(postgres)).join();
        }

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {

        }
    }
}
