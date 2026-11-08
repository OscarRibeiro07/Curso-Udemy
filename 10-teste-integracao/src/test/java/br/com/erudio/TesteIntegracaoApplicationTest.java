package br.com.erudio;

import br.com.erudio.config.TestConfig;
import br.com.erudio.integrationstest.testcontainers.AbstracIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TesteIntegracaoApplicationTest extends AbstracIntegrationTest {


    @LocalServerPort
    private int port=8888;



    @Test
    void shouldDisplaySwaggerUIPage() {

        var content = given().
        basePath("/swagger-ui/index.html")
                .port(port)
        .when()
                .get()
       .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        assertTrue(content.contains("Swagger UI"));


    }

}
