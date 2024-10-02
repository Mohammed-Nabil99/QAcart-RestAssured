package com.qacart.academy.testcases;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class InfoTest {
    RequestSpecification request;

    @BeforeClass
    public void beforeClass() {
        request = given()
                .baseUri("https://todo.qacart.com")
                .log().all();
    }

    @Test
    public void shouldBeAbleToGetCoursesInfo() {
        HashMap <String,String> infoHeader=new HashMap<>();
        infoHeader.put("type","WEB");
        infoHeader.put("language","JAVA");

        given()
                .spec(request)
                .headers(infoHeader)
        .when()
                .get("api/v1/info/courses")
        .then()
                .log().all()
                .assertThat()
                    .statusCode(200)
                    .body("count",equalTo(1));
    }


    @Test
    public void shouldBeAbleToGetLecturesInfo() {
        HashMap <String,String> queryParams=new HashMap<>();
        queryParams.put("mod","VIDEO");
        queryParams.put("type","FREE");

        given()
                .spec(request)
                .queryParams(queryParams)
                .when()
                .get("api/v1/info/lectures")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}

