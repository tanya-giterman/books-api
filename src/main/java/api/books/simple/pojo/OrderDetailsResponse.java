package api.books.simple.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class OrderDetailsResponse {
    private String id;
    private int bookId;
    private String customerName;
    private String createdBy;
    private int quantity;
    private long timestamp;

    public OrderDetailsResponse(String id, int bookId, String customerName, String createdBy, int quantity, long timestamp) {
        this.id = id;
        this.bookId = bookId;
        this.customerName = customerName;
        this.createdBy = createdBy;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public OrderDetailsResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsResponse that = (OrderDetailsResponse) o;
        return bookId == that.bookId && quantity == that.quantity && timestamp == that.timestamp && Objects.equals(id, that.id) && Objects.equals(customerName, that.customerName) && Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, customerName, createdBy, quantity, timestamp);
    }

    @Override
    public String toString() {
        return "OrderDetailsResponse{" +
                "id='" + id + '\'' +
                ", bookId=" + bookId +
                ", customerName='" + customerName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", quantity=" + quantity +
                ", timestamp=" + timestamp +
                '}';
    }
}
