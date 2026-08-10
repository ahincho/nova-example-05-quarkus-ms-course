package com.nova.generics.ms.course.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * Integration test that boots the Quarkus runtime on the test port
 * and verifies the application starts and reports itself healthy.
 */
@QuarkusTest
class ApplicationTest {

    @Test
    void healthEndpointReportsUp() {
        given()
                .when().get("/q/health")
                .then()
                .statusCode(200)
                .body("status", is("UP"));
    }
}