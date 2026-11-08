package br.com.erudio.configDoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI() {

        return new OpenAPI().info(new Info()
                .title("REST API´s RESTful from 0 with Java, Spring boot, Kubernets and Docker")
                .version("v1")
                .description("REST API´s")
                .termsOfService("https://mr-tech73.webnode.page/politica-de-privacidade/")
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.txt"))
        );
    }

}
