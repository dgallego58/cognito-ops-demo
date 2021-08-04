package co.com.cognito.main;

import co.com.cognito.ops.AuthService;
import co.com.cognito.ops.SignUp;

public class Demo {

    public static void main(String[] args) {
        AuthService service = AuthService.factory().get("cognito");
        var result = service.signUp(SignUp.create()
                .setEmail("elcorreo@elcorreo.com")
                .setPassword("ElTest1234*")
                .setUsername("elusername94")
        );
        System.out.printf("El resultado es %s", result.toString());
    }
}
