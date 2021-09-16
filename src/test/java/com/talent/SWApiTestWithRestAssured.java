package com.talent;




import io.restassured.path.json.JsonPath;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import static com.jayway.jsonpath.JsonPath.parse;
import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;
import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class SWApiTestWithRestAssured {
/*
    @Test
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {

        RestAssured
                .given()
                .queryParam("format", "json")
                .config(config().logConfig(logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails()))
                .when().get("https://swapi.dev/api/people/2/")
                .then().assertThat()
                .statusCode(is(equalTo(200)))
                .assertThat()
                .body("name",equalTo("Luke Skywalker"))
                .log()
                .all();

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
        String response = get("https://swapi.dev/api/people/").asString();
       // System.out.println(response);
        List<String> films = from(response).getList("results.films[1]");
        System.out.println(films);
        assertThat(films.size(), is(6));


}

    @Test
    public void whenTypeListtoString() {

        String response = get("https://swapi.dev/api/people/").asString();

        // System.out.println(response);
        String films = from(response).getString("results.films[1][1]");
        System.out.println(films);
        assertThat(films.toUpperCase(),is("https://swapi.dev/api/films/2/"));

    }

    @Test
    public void whenTypeListCondition() {
  //  List<String> list=new ArrayList<String>();
    Response response = get("https://swapi.dev/api/people/");
    JsonPath jsonPathEvaluator = response.jsonPath();
    List<String> list00 = jsonPathEvaluator.get("results.films[0]");
    List<String> list01 = jsonPathEvaluator.get("results.films[1]");
        List<String> list03 = jsonPathEvaluator..get("results.films[2]");
    //int evaluator = jsonPathEvaluator.getInt("results.films.length().sum()");
    assertThat(list00.size()+list01.size()+list03.size(), is(16));


    }
*/
    @Test
    public void whenTypeListCondition() {
 JsonPath result = get("https://swapi.dev/api/people/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();


System.out.println(result);

    }


/*
    @Test
    public void whenTypeIntCondition() {


        List<String> list=new ArrayList<String>();
        Response response = get("https://swapi.dev/api/people/");
        JsonPath jsonPathEvaluator = response.jsonPath();
        list = jsonPathEvaluator.get("results.films[3]");
        assertThat(list.size(), is(4));
    }*/
}