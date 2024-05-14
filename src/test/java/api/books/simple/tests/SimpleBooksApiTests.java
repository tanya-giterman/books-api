package api.books.simple.tests;
import static api.books.simple.api.ApiOperations.*;
import api.books.simple.pojo.*;
import static api.books.simple.api_constants.ApiEndPoints.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;
import static api.books.simple.api_constants.ApiStatus.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class SimpleBooksApiTests {
//    @BeforeClass
//    public static void setUp(){
//        Response response = (Response) given();
//    }
    @Test
    public void getAppStatusTest(){

                performGetRequest(GET_STATUS_ENDPOINT, false)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("status", equalTo("OK"));

//        given()
//                .when()
//                .get(GET_STATUS_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("status", equalTo("OK"));
    }
    @Test
    public void getListOfBooksTest(){
        performGetRequest(GET_ALL_BOOKS_ENDPOINT, false)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("size()", equalTo(6))
                .body("", Matchers.instanceOf(List.class));


//        given()
//                .when()
//                .get(GET_ALL_BOOKS_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .body("", Matchers.instanceOf(List.class))
//                .contentType(ContentType.JSON)
//                .body("size()", equalTo(6));

    }
    @Test
    public void getListOfBooksWithTypeQueryParamTest(){
        performGetRequestQueryParam(GET_ALL_BOOKS_ENDPOINT, "type", "non-fiction", false)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("size()", equalTo(2))
                .body("", Matchers.instanceOf(List.class));

//        given()
//                .queryParam("type", "non-fiction")
//                .when()
//                .get(GET_ALL_BOOKS_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .body("", Matchers.instanceOf(List.class))
//                .contentType(ContentType.JSON)
//                .body("size()", equalTo(2));

    }

    @Test
    public void getListOfBooksWithLimitQueryParamTest(){
        performGetRequestQueryParam(GET_ALL_BOOKS_ENDPOINT, "limits", String.valueOf(2), false)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("size()", equalTo(6))
                .body("", Matchers.instanceOf(List.class));

//        given()
//                .queryParam("limit", "5")
//                .when()
//                .get(GET_ALL_BOOKS_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .body("", Matchers.instanceOf(List.class))
//                .contentType(ContentType.JSON)
//                .body("size()", equalTo(5));

    }

    @Test
    public void getSingleBookByIdTest(){
        performGetRequestPathParam(GET_ONE_BOOK_ENDPOINT, "bookID", String.valueOf(2), false)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("id", equalTo(2))
                .body("name", equalTo("Just as I Am"));

//        given()
//                .pathParam("bookID", "bookID")
//                .when()
//                .get(GET_ONE_BOOK_ENDPOINT)
//                .then()
//                .contentType(ContentType.JSON)
//                .statusCode(200)
//                .body("id", equalTo(2))
//                .body("name", equalTo("Just as I Am"));
    }
    @Test
    public void getSingleBookByIdNegativeTest(){
        performGetRequestPathParam(GET_ONE_BOOK_ENDPOINT, "bookID", String.valueOf(20), false)
                .then()
                .statusCode(NOT_FOUND.getStatusCode())
                .contentType(ContentType.JSON)
                .body("error", equalTo("No book with id 20"));

//        given()
//                .pathParam("bookID", 20)
//                .when()
//                .get(GET_ONE_BOOK_ENDPOINT)
//                .then()
//                .statusCode(404)
//                .contentType(ContentType.JSON)
//                .body("error", equalTo("No book with id 20"));

    }
    @Test
    public void getSingleBookByIdValidateAllFieldsJSONPathTest(){
        Response response = performGetRequestPathParam(GET_ONE_BOOK_ENDPOINT, "bookID", String.valueOf(1), false)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .extract()
                .response();

//        Response response = given()
//                .pathParam("bookID", 1)
//                .when()
//                .get(GET_ONE_BOOK_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .extract()
//                .response();

//        Response response = response;
//        String string = response.asString();
//        System.out.println(string);
//        String id = response.jsonPath().getString("id");
//        System.out.println(id);


        int id = response.jsonPath().getInt("id");
        String name = response.jsonPath().getString("name");
        String author = response.jsonPath().getString("author");
        String isbn = response.jsonPath().getString("isbn");
        String type = response.jsonPath().getString("type");
        double price = response.jsonPath().getDouble("price");
        int currentStock = response.jsonPath().getInt("current-stock");
        boolean available = response.jsonPath().getBoolean("available");
        Assert.assertEquals(1, id);
        Assert.assertEquals("The Russian", name);
        Assert.assertEquals("James Patterson and James O. Born", author);
        Assert.assertEquals("1780899475", isbn);
        Assert.assertEquals("fiction", type);
        Assert.assertEquals(12.98, price, 0.01);
        Assert.assertEquals(12, currentStock);
        Assert.assertEquals(true, available);
    }
    @Test
    public void getSingleBookByIdValidateAllFieldsPojoTest() {

        Response response = performGetRequestPathParam(GET_ONE_BOOK_ENDPOINT, "bookID", String.valueOf(1), false)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .extract()
                .response();

//        Response response = given()
//                .pathParam("bookID", 1)
//                .when()
//                .get(GET_ONE_BOOK_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .extract()
//                .response();

        BookDetailsResponse bookDetailsResponse = response.as(BookDetailsResponse.class);
        System.out.println(bookDetailsResponse);
        Assert.assertEquals(1, bookDetailsResponse.getId());
        Assert.assertEquals("The Russian", bookDetailsResponse.getName());
        Assert.assertEquals("James Patterson and James O. Born", bookDetailsResponse.getAuthor());
        Assert.assertEquals("1780899475", bookDetailsResponse.getIsbn());
        Assert.assertEquals("fiction", bookDetailsResponse.getType());
        Assert.assertEquals(12.98, bookDetailsResponse.getPrice(), 0.01);
        Assert.assertEquals(12, bookDetailsResponse.getCurrentStock());
        Assert.assertEquals(true, bookDetailsResponse.isAvailable());

    }

    @Test
    public void getListOfBooksVerifyEachTest(){

        Response response = given()
                .when()
                .get(GET_ALL_BOOKS_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .response();
        BookResponse[] bookObj = response.as(BookResponse[].class);
        for (BookResponse obj: bookObj) {
            System.out.println(obj);
            Assert.assertTrue(obj.getId() != null);
        }
    }


    @Test
    public void postSubmitBookOrderTest(){
        SubmitOrderRequest requestPayload = new SubmitOrderRequest(6, "Jimmy Hudson");
        performPostRequest(POST_ALL_ORDERS_ENDPOINT, requestPayload, true)
                .then()
                .statusCode(CREATED.getStatusCode())
                .contentType(ContentType.JSON)
                .body("created", equalTo(true))
                .body("orderId", notNullValue());

//        SubmitOrderRequest submitOrderRequest = new SubmitOrderRequest(6, "Jimmy Hudson");
//        given()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .body(submitOrderRequest)
//                .when()
//                .post(POST_ALL_ORDERS_ENDPOINT)
//                .then()
//                .statusCode(201)
//                .contentType(ContentType.JSON)
//                .body("created", equalTo(true))
//                .body("orderId", notNullValue());

    }

    @Test
    public void postSubmitBookOrderBadTest(){
        SubmitOrderRequest requestPayload = new SubmitOrderRequest(20, "Jimmy Hudson");
        performPostRequest(POST_ALL_ORDERS_ENDPOINT, requestPayload, true)
                .then()
                .statusCode(BAD_REQUEST.getStatusCode())
                .contentType(ContentType.JSON)
                .body("error", equalTo("Invalid or missing bookId."));



//        given()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .body("{\n" +
//                        "  \"bookId\": 6,\n" +
//                        "  \"customerName\": \"Mary Okay\"\n" +
//                        "}")
//                .when()
//                .post(POST_ALL_ORDERS_ENDPOINT)
//                .then()
//                .statusCode(201)
//                .contentType(ContentType.JSON)
//                .body("created", equalTo(true))
//                .body("orderId", notNullValue());

    }
    @Test
    public void postSubmitBookOrderWithNoAccessTokenNegativeTest(){
        SubmitOrderRequest requestPayload = new SubmitOrderRequest(6, "Jimmy Hudson");
        performPostRequest(POST_ALL_ORDERS_ENDPOINT, requestPayload, false)
                .then()
                .statusCode(UNAUTHORIZED.getStatusCode())
                .contentType(ContentType.JSON)
                .body("error", equalTo("Missing Authorization header."));

//        SubmitOrderRequest submitOrderRequest = new SubmitOrderRequest(6, "Jimmy Hudson");
//        given()
//                .contentType(ContentType.JSON)
//                .body(submitOrderRequest)
//                .when()
//                .post(POST_ALL_ORDERS_ENDPOINT)
//                .then()
//                .statusCode(401)
//                .contentType(ContentType.JSON)
//                .body("error", equalTo("Missing Authorization header."));

    }
    @Test
    public void postSubmitBookOrderWithInvalidTokenNegativeTest(){

        SubmitOrderRequest submitOrderRequest = new SubmitOrderRequest(6, "Jimmy Hudson");
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer "+ "1234567890")
                .body(submitOrderRequest)
                .when()
                .post(POST_ALL_ORDERS_ENDPOINT)
                .then()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .body("error", equalTo("Invalid bearer token."));

    }

    @Test
    public void getAllOrdersTest(){

        performGetRequest(GET_ALL_ORDERS_ENDPOINT, true)
                .then()
                .statusCode(OK.getStatusCode())
                .contentType(ContentType.JSON)
                .body("",Matchers.instanceOf(List.class));

//        given()
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .when()
//                .get(GET_ALL_ORDERS_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("",Matchers.instanceOf(List.class));
    }
    @Test
    public void getSingleOrderTest(){
        String orderId = placeOrderAndGetId();
        performGetRequestPathParam(GET_ONE_ORDER_ENDPOINT,"orderId", orderId, true )
                .then()
                .contentType(ContentType.JSON)
                .statusCode(OK.getStatusCode())
                .body("id", equalTo(orderId));

//        given()
//                .pathParam("orderId", orderId)
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .when()
//                .get(GET_ONE_ORDER_ENDPOINT)
//                .then()
//                .contentType(ContentType.JSON)
//                .statusCode(200)
//                .body("id", equalTo(orderId));

    }
    private String placeOrderAndGetId(){
        return performPostRequest(POST_ALL_ORDERS_ENDPOINT, new SubmitOrderRequest(3,"Tom Brady"), true)
                .then()
                .statusCode(CREATED.getStatusCode())
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .jsonPath()
                .getString("orderId");

//        return given()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .body(new SubmitOrderRequest(3,"Tom Brady"))
//                .when()
//                .post(POST_ALL_ORDERS_ENDPOINT)
//                .then()
//                .statusCode(CREATED.getStatusCode())
//                .contentType(ContentType.JSON)
//                .extract()
//                .response()
//                .jsonPath()
//                .getString("orderId");
    }

    @Test
    public void deleteOrderTest(){

        String orderId = placeOrderAndGetId();
        performDeleteRequest(DELETE_ONE_ORDER_ENDPOINT,"orderId", orderId)
                .then()
                .statusCode(NO_CONTENT.getStatusCode());

//        given()
//                .pathParam("orderId", orderId)
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .when()
//                .delete(DELETE_ONE_ORDER_ENDPOINT)
//                .then()
//                .statusCode(204);
    }

    @Test
    public void patchOrderTest(){
        String orderId = placeOrderAndGetId();
        String updatedCustomerName = "Mike Smith";

        performPatchRequest(PATCH_ONE_ORDER_ENDPOINT, "orderId", orderId, new UpdateOrderRequest(updatedCustomerName))
                .then()
                .statusCode(NO_CONTENT.getStatusCode());

        performGetRequestPathParam(GET_ONE_ORDER_ENDPOINT,"orderId", orderId, true )
                .then()
                .contentType(ContentType.JSON)
                .statusCode(OK.getStatusCode())
                .extract()
                .response()
                .as(OrderDetailsResponse.class);

//        given()
//                .pathParam("orderId", orderId)
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .contentType(ContentType.JSON)
//                .body(new UpdateOrderRequest(updatedCustomerName))
//                .when()
//                .patch(PATCH_ONE_ORDER_ENDPOINT)
//                .then()
//                .statusCode(204);
//
//      OrderDetailsResponse orderDetailsResponse = given()
//
//                .pathParam("orderId", orderId)
//                .header("Authorization", "Bearer "+ ACCESS_TOKEN)
//                .get(GET_ONE_ORDER_ENDPOINT)
//                .then()
//                .contentType(ContentType.JSON)
//                .statusCode(200)
//                .extract()
//                .response()
//                .as(OrderDetailsResponse.class);
//        System.out.println(orderDetailsResponse);



    }







}
