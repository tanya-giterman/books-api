package api.books.simple.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookDetailsResponse {

    private int id;
    private String name;
    private String author;
    private String isbn;
    private String type;
    private double price;
    @JsonProperty("current-stock")
    private int currentStock;
    private boolean available;

    public BookDetailsResponse(int id, String name, String author, String isbn, String type, double price, int currentStock, boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.type = type;
        this.price = price;
        this.currentStock = currentStock;
        this.available = available;
    }

    public BookDetailsResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDetailsResponse that = (BookDetailsResponse) o;
        return id == that.id && Double.compare(price, that.price) == 0 && currentStock == that.currentStock && available == that.available && Objects.equals(name, that.name) && Objects.equals(author, that.author) && Objects.equals(isbn, that.isbn) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, isbn, type, price, currentStock, available);
    }

    @Override
    public String toString() {
        return "BookDetailsResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", currentStock=" + currentStock +
                ", available=" + available +
                '}';
    }
}
