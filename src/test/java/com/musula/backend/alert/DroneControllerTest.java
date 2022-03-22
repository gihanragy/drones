package com.musula.backend.alert;

import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestPropertySource(locations = {"classpath:application-test.properties"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DroneControllerTest {


    @Test
    void aListAlertsWithCustomerIDAsAdmin() {
        Object input = new Object();
        ResponseBodyExtractionOptions response = given().
                accept("application/json").
                contentType("application/json").
                body(input).
                when().
                post("/drone/list").
                then().
                statusCode(200).
                extract().body();

             // Assertions.assertNotNull(list);
          }





}
