package com.qacart.academy.testcases;
import com.qacart.academy.LoginPojo.LoginPojo;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class StudentsTest {

    @Test
    public void shouldBeAbleToLoginToTheApplication() {
        LoginPojo body = new LoginPojo("eng.mohammed.nabil99@gmail.com","Test123!");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("/api/v1/students/login")
        .then()
                .log().all()
                    .assertThat()
                    .statusCode(200);
    }
}
