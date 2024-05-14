package api.books.simple.pojo;

public class ApiClientResponseBody {
    private String accessToken;

    public ApiClientResponseBody(String accessToken) {
        this.accessToken = accessToken;
    }

    public ApiClientResponseBody() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
        return "ApiClientResponseBody{" +
                "accessToken='" + accessToken + '\'' +
                '}';
    }
}
