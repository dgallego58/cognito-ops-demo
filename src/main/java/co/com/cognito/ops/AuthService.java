package co.com.cognito.ops;

import java.util.HashMap;
import java.util.Map;

public interface AuthService {

    Map<String, Object> signUp(SignUp signUp);

    static Map<String, AuthService> factory(){
        Map<String, AuthService> clients = new HashMap<>();
        clients.put("cognito", CognitoService.create());
        return clients;
    }

}
