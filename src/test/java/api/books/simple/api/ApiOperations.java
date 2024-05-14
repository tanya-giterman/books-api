package api.books.simple.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiOperations {
    public static final String ACCESS_TOKEN = "fa1cdf7c16bba2aea7f0182524a7163f7292fbe6630a8663595e8bbc051e2e17";
    private ApiOperations(){

    }
    public static Response performGetRequest(String endpoint, boolean requiresAuth){
        RequestSpecification requestSpecification = given();
        if (requiresAuth){
            requestSpecification = requestSpecification.header("Authorization", ACCESS_TOKEN);
        }
        return requestSpecification
                .when()
                .get(endpoint);
    }

    public static Response performGetRequestQueryParam(String endpoint, String paramKey, String paramValue, boolean requiresAuth){
        RequestSpecification requestSpecification = given();
        if (requiresAuth){
            requestSpecification = requestSpecification.header("Authorization", ACCESS_TOKEN);
        }
        return requestSpecification
                .queryParam(paramKey, paramValue)
                .when()
                .get(endpoint);
    }

    public static Response performGetRequestPathParam(String endpoint, String paramKey, String paramValue, boolean requiresAuth){
        RequestSpecification requestSpecification = given();
        if (requiresAuth){
            requestSpecification = requestSpecification.header("Authorization", ACCESS_TOKEN);
        }
        return requestSpecification
                .pathParam(paramKey, paramValue)
                .when()
                .get(endpoint);
    }
    public static Response performPostRequest(String endpoint, Object payload, boolean requiresAuth){
        RequestSpecification requestSpecification = given();
        if (requiresAuth){
            requestSpecification = requestSpecification.header("Authorization", ACCESS_TOKEN);
        }
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(endpoint);
    }
    public static Response performPatchRequest(String endpoint, String paramKey, String paramValue, Object payload){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", ACCESS_TOKEN)
                .body(payload)
                .pathParams(paramKey, paramValue)
                .when()
                .patch(endpoint);
    }
    public static Response performDeleteRequest(String endpoint, String paramKey, String paramValue){
        return given()
                .header("Authorization", ACCESS_TOKEN)
                .pathParams(paramKey, paramValue)
                .when()
                .delete(endpoint);
    }

}
