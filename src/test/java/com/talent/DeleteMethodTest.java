package com.talent;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteMethodTest {

    @Before
    public void setup() {

        RestAssured.baseURI = "http://localhost:3000/";
        RestAssured.basePath = "/posts";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification=new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }
    /*@Test
    public void deleteUserTest() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }*/
    @Test
    public void getAllTest() {
       String nameUpdated= given()
                .body("{\n" +
                        "    \"title\": \"Anita's\"\n" +
                        "}")
                .patch("/1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getString("title");

              assertThat(nameUpdated,equalTo("Anita"));
    }
  /*  @Test
    public void putUserTest () {

        String nameUpdated= given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .patch("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getString("job");

        assertThat(nameUpdated,equalTo("zion resident"));

    }*/

}
