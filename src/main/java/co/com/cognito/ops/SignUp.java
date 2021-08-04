package co.com.cognito.ops;

public class SignUp {

    private String username;
    private String email;
    private String password;

    public static SignUp create(){
        return new SignUp();
    }

    public String getUsername() {
        return username;
    }

    public SignUp setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SignUp setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SignUp setPassword(String password) {
        this.password = password;
        return this;
    }
}
