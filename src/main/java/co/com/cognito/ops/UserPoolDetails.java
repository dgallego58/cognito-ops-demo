package co.com.cognito.ops;

public class UserPoolDetails {

    private final String userPoolId;
    private final String userPoolClientId;

    public static UserPoolDetails from(String userPoolId, String userPoolClientId){
        return new UserPoolDetails(userPoolId, userPoolClientId);
    }

    private UserPoolDetails(String userPoolId, String userPoolClientId) {
        this.userPoolId = userPoolId;
        this.userPoolClientId = userPoolClientId;
    }

    public String getUserPoolId() {
        return userPoolId;
    }

    public String getUserPoolClientId() {
        return userPoolClientId;
    }
}
