

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ResponseTests {

    @Test
    public void testSearchName() {
        given()
                .baseUri("https://66fc7479c3a184a84d1718ea.mockapi.io")
        .when()
                .get("/api/v1/users")
        .then() .log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("name",hasItem("Dewey Hane"));
    }

    @Test
    public void testGetUsers() {
        Response res = given().baseUri("https://66fc7479c3a184a84d1718ea.mockapi.io")
                .when().get("/api/v1/users")
                .then().extract().response();

        System.out.println(res.asString());
        String name = res.path("[0].name");
        System.out.println(name);
    }

    @Test
    public void testInvalidName() {
        given()
                .baseUri("https://66fc7479c3a184a84d1718ea.mockapi.io").log()
                .ifValidationFails()
        .when()
                .get("/api/v1/users")
        .then()
                .log().ifValidationFails()
                     .body("[0].name", equalTo("John Do"));
    }

}