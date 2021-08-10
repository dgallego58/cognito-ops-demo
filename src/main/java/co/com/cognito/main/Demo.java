package co.com.cognito.main;

import co.com.cognito.ops.AuthService;
import co.com.cognito.ops.SignIn;
import co.com.cognito.ops.SignUp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        AuthService service = AuthService.factory().get("cognito");
        var result = service.signUp(SignUp.create()
                .setEmail("elcorreo@elcorreo.com")
                .setPassword("ElTest1234*")
                .setUsername("elusername94")
        );
        LOG.info("El resultado es {}", result.toString());

        LOG.info("Authentication is {}", service.signIn(SignIn.from("elusername94", "ElTest1234*")));

    }
}
