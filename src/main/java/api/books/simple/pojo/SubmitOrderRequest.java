package api.books.simple.pojo;

import java.util.Objects;

public class SubmitOrderRequest {
    private int bookId;
    private String customerName;

    public SubmitOrderRequest(int bookId, String customerName) {
        this.bookId = bookId;
        this.customerName = customerName;
    }

    public SubmitOrderRequest() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmitOrderRequest submitOrderRequest = (SubmitOrderRequest) o;
        return bookId == submitOrderRequest.bookId && Objects.equals(customerName, submitOrderRequest.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, customerName);
    }

    @Override
    public String toString() {
        return "OrderBody{" +
                "bookId=" + bookId +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
