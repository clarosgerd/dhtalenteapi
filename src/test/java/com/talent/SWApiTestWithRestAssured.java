package com.talent;


import com.talent.bind.BaseApiResponse;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class SWApiTestWithRestAssured {

    @Test
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {


        RestAssured
                .given()
                .queryParam("format", "json")
                .config(config().logConfig(logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails()))
                .when().get("https://swapi.dev/api/people/1/")
                .then().assertThat()
                .statusCode(is(equalTo(200))).assertThat().body("name",equalTo("Luke Skywalker")).log().all();



    }
    @Test
    public void whenTypeString() {




        RestAssured
                .given()
                .queryParam("format", "json")
                .config(config().logConfig(logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails()))
                .when().get("https://swapi.dev/api/people/2/")
                .then().assertThat()
                .statusCode(is(equalTo(200)))
                .assertThat()
                .body("homeworld",equalTo("https://swapi.dev/api/planets/1/"))
                .log()
                .all();
    }
    @Test
    public void whenTypeList() {


        List<Map<String, Object>> people = get("https://swapi.dev/api/people/1/").as(new TypeRef<List<Map<String, Object>>>() {});


        // assertThat(people.get(0).get("count"), equalTo(82));
        assertThat(people.get(0).get("name"), equalTo("Luke Skywalker"));
        //    assertThat(people.get(0).get("height"), equalTo("172"));
        //    assertThat(people.get(0).get("mass"), equalTo(77));

    }

}