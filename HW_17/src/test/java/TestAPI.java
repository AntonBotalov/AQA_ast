import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class TestAPI {
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void getRequest() {
        given()
                .baseUri(BASE_URL)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
        .when()
                .get( "/get")
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .contentType("text/plain")
                .body(requestBody)
        .when()
                .post("/post")
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(requestBody));
    }

    @Test
    public void postFormData() {
        given()
                .baseUri(BASE_URL)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .log().all()
        .when()
                .post("/post")
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .contentType("text/plain")
                .body(requestBody)
        .when()
                .put("/put")
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(requestBody));
    }

    @Test
    public void patchRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .contentType("text/plain")
                .body(requestBody)
        .when()
                .patch("/patch")
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(requestBody));
    }

    @Test
    public void deleteRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .contentType("text/plain")
                .body(requestBody)
        .when()
                .delete("/delete")
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(requestBody));
    }
}
