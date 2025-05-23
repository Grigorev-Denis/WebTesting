package pojo;

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public AuthResponse() {
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return '{' +
                "token='" + token + '\'' +
                '}';
    }
}
