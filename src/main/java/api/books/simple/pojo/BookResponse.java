package api.books.simple.pojo;

import lombok.*;


public class BookResponse {

        private Integer id;
        private String name;
       private String type;
       private boolean available;

    public BookResponse(Integer id, String name, String type, boolean available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.available = available;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public BookResponse() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", available=" + available +
                '}';
    }
}
