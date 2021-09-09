package com.talent;


import com.talent.bind.BaseApiResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.*;



public class SWApiTestWithRestAssured {

    @Test
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {

        BaseApiResponse baseApiResponse = RestAssured
                .given()
                .baseUri("https://swapi.dev/api" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "")
                .and()
                .queryParam("format", "json")
                .when()
                .get("/")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and()
                .body("films", response -> notNullValue())
                .body("vehicles", response -> notNullValue())
                .body("people", response -> notNullValue())
                .body("starships", response -> notNullValue())
                .body("species", response -> notNullValue())
                .body("planets", response -> notNullValue())
                .and().extract().body().as(BaseApiResponse.class);

        RestAssured
                .given()
                .queryParam("format", "json")
                .log().all()
                .when()
                .post(baseApiResponse.getPlanets())
                .then()
                .log().all()
                .and()
                .assertThat()
                .statusCode(is(equalTo(405)));

    }


}