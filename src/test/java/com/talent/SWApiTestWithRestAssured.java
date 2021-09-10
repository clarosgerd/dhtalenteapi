package com.talent;


import com.talent.bind.BaseApiResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;


import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static org.hamcrest.Matchers.*;



public class SWApiTestWithRestAssured {

    @Test
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured
                .given()
                .queryParam("format", "json")
                .when()
                .get("https://swapi.dev/api/")
                .then()
                .assertThat().statusCode(is(equalTo(200)));

        RestAssured
                .given()
                .queryParam("format", "json")
                .when()
                .post("https://swapi.dev/api/films/")
                .then()
                .assertThat().statusCode(is(equalTo(200)));
    }



}