package com.talent;

import com.talent.model.Users;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.from;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ObjectMethodTest {

    @Before
    public void setup() {

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
      //  RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }

    /*@Test
    public void deleteUserTest() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
    @Test
    public void getAllUserTest() {
        Response response = given()
                .get("users?page=2");

        Headers header = response.getHeaders();

        int statusCode = response.getStatusCode();
        String body = response.getBody().asString();
        String contentType = response.getContentType();

        assertThat(statusCode, equalTo(HttpStatus.SC_OK));

        System.out.println("------------DATOS HEADER-----------------");
        System.out.println("statusCode:" +statusCode);
        System.out.println("body:" +body);
        System.out.println("contentType: " +contentType);

        System.out.println("-----------------------------");

        System.out.println("contentType1: "+(header.get("Content-Type")));
        System.out.println("Transfer-Encoding1: "+(header.get("Transfer-Encoding")));
    }


    @Test
    public void getAllUserTestJson() {

        String response=given().get("users?page=2").then().extract().body().asString();

        int page= from(response).get("page");
        int totalpage= from(response).get("total_pages");
        int id= from(response).get("data[0].id");
        System.out.println("page:" +page);
        System.out.println("totalpage:" +totalpage);
        System.out.println("firsId:" +id);

        List<Map> userWhitMap= from(response).get("data.findAll {user->user.id>10} ");

        String email =userWhitMap.get(0).get("email").toString();

        List<Map> userList= from(response).get("data.findAll{user->user.id > 10 && user.last_name=='Howell'}");

        int idtest = Integer.valueOf(userList.get(0).get("id").toString());



        System.out.println("idtest:" +idtest);

    }*/
    @Test
    public void createUserTest() {

        String response=given().when().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").post("/users").then().extract().asString();

        Users user= from(response).getObject("", Users.class);

        System.out.println("id:"+user.getId());
        System.out.println("name:"+user.getName());
        System.out.println("createdAt:"+user.getCreatedAt());


    }
}
