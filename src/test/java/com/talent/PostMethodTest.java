package com.talent;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostMethodTest {

    @Test
    public void loginTest() {

        String response = RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@regress.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log()
                .all()
                .extract()
                .asString();

        System.out.println(response);

    }
    @Test
    public void withoutPasswordloginTest() {

      RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"sydney@fife\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error",equalTo("user not found"));;


    }
/*
    @Test //Veriicar correso con correos temporales que no tiene dominio valido
    public void validloginTest() {

        RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@regress.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("token",notNullValue());



    }
    @Test //Veriicar correso con correos temporales que no tiene dominio valido
    public void invalidloginTest() {

        RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@mailinator.com\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .body("error",equalTo("user not found"));

    }

    @Test
    public void loginTestAssert() {

        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(300)
                .body("token",notNullValue());

    }
*/

}
