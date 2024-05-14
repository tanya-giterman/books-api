package api.books.simple.api_constants;

public class ApiEndPoints {
    public final static String BASE_URL ="https://simple-books-api.glitch.me";
    public final static String GET_STATUS_ENDPOINT ="https://simple-books-api.glitch.me/status";
    public final static String GET_ALL_BOOKS_ENDPOINT ="https://simple-books-api.glitch.me/books";
    public final static String GET_ONE_BOOK_ENDPOINT =GET_ALL_BOOKS_ENDPOINT+ "/{bookID}";
    public final static String GET_ALL_ORDERS_ENDPOINT ="https://simple-books-api.glitch.me/orders";
    public final static String POST_ALL_ORDERS_ENDPOINT ="https://simple-books-api.glitch.me/orders";
    public final static String GET_ONE_ORDER_ENDPOINT =GET_ALL_ORDERS_ENDPOINT+"/{orderId}";
    public final static String PATCH_ONE_ORDER_ENDPOINT =GET_ALL_ORDERS_ENDPOINT+"/{orderId}";
    public final static String DELETE_ONE_ORDER_ENDPOINT =GET_ALL_ORDERS_ENDPOINT+"/{orderId}";
    public final static String POST_REGISTER_CLIENT_ENDPOINT ="https://simple-books-api.glitch.me/api-clients";
}
