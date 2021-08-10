package co.com.cognito.ops;

public class SignIn {

    private String username;
    private String password;

    private SignIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static SignIn from(String username, String password) {
        return new SignIn(username, password);
    }

    public String getUsername() {
        return username;
    }

    public SignIn setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SignIn setPassword(String password) {
        this.password = password;
        return this;
    }
}
