package api.books.simple.pojo;

public class ClientRequestBody {
    private String clientName;
    private String clientEmail;

    public ClientRequestBody(String clientName, String clientEmail) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public ClientRequestBody() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
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
        return "ClientRequestBody{" +
                "clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
