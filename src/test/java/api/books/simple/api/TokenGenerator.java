package api.books.simple.api;

import api.books.simple.pojo.ApiClientResponseBody;
import api.books.simple.pojo.ClientRequestBody;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.books.simple.api_constants.ApiEndPoints.BASE_URL;
import static api.books.simple.api_constants.ApiEndPoints.POST_REGISTER_CLIENT_ENDPOINT;
import static api.books.simple.api_constants.ApiStatus.CREATED;
import static api.books.simple.api_constants.ApiStatus.OK;
import static io.restassured.RestAssured.given;

public class TokenGenerator {
    private TokenGenerator() {
    }

    public static String generateToken(){

        String[] email ={"@gmail.com", "@yahoo.com", "@hotmail.com"};
        Faker faker = new Faker();
        String clientName = faker.name().fullName();
        String clientEmail = clientName.toLowerCase().replace(" ","")+email[(int)(Math.random()*email.length)];
        String payload = "clientName " + clientName + "clientEmail" + clientEmail;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(POST_REGISTER_CLIENT_ENDPOINT)
                .then()
                .statusCode(CREATED.getStatusCode())
                .extract()
                .response();
        return response
                .jsonPath()
                .getString("accessToken");

    }
}
