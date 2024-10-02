package com.qacart.academy.testcases;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class CoursesTest {

    @Test
    public void shouldBeAbleToGetCoursesDetails() {
        given()
                .baseUri("https://todo.qacart.com")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2ZmRjNDFlZGVlMmM5MDAxNGUzYzEyOCIsImZpcnN0TmFtZSI6Ik1vaGFtZWQiLCJsYXN0TmFtZSI6Ik5hYmlsIiwiaWF0IjoxNzI3OTA3MTY3fQ.N1ANUcHbml63JM7KUMp68danFf_sKM6IbOsSC8NUX1Y\n")
        .when()
                .get("/api/v1/courses/6319b5655ce1f40db1b73738")
        .then()
                .log().all()
                    .assertThat()
                    .statusCode(200);
    }
}
