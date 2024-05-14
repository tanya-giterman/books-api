package api.books.simple.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UpdateOrderRequest {

    private String customerName;

    public UpdateOrderRequest(String customerName) {
        this.customerName = customerName;
    }

    public UpdateOrderRequest() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "UpdateOrderRequest{" +
                "customerName='" + customerName + '\'' +
                '}';
    }
}
