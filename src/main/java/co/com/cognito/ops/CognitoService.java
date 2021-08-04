package co.com.cognito.ops;

import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminConfirmSignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminUpdateUserAttributesRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.SignUpRequest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CognitoService implements AuthService {

    private static final CognitoClientFactory CLIENT_FACTORY;

    static {
        CLIENT_FACTORY = CognitoClientFactory.LOCAL_INSTANCE;
    }

    private final String userPoolId;
    private final String userPoolClientId;

    private CognitoService() {
        //fun
        this.userPoolId = CLIENT_FACTORY.details().getUserPoolId();
        this.userPoolClientId = CLIENT_FACTORY.details().getUserPoolClientId();
    }

    public static AuthService create() {
        return new CognitoService();
    }

    @Override
    public Map<String, Object> signUp(SignUp signUp) {

        SignUpRequest request = SignUpRequest.builder()
                .userAttributes(
                        attributeTypes(Map.of("email", signUp.getEmail()))
                )
                .username(signUp.getUsername())
                .password(signUp.getPassword())
                .clientId(userPoolClientId)
                .build();

        AdminConfirmSignUpRequest adminConfirmSignUp = AdminConfirmSignUpRequest
                .builder()
                .username(signUp.getUsername())
                .userPoolId(userPoolId)
                .build();

        AdminUpdateUserAttributesRequest adminUpdateUserAttr = AdminUpdateUserAttributesRequest
                .builder()
                .userPoolId(userPoolId)
                .username(signUp.getUsername())
                .userAttributes(attributeTypes(Map.of("email_verified", "true")))
                .build();

        var signUpResponse = CLIENT_FACTORY.client().signUp(request);
        var adminConfirmationResponse = CLIENT_FACTORY.client().adminConfirmSignUp(adminConfirmSignUp);
        var updateUserAtt = CLIENT_FACTORY.client().adminUpdateUserAttributes(adminUpdateUserAttr);
        return Map.of("signUpResp", signUpResponse,
                "adminConfirmResp", adminConfirmationResponse,
                "adminUpdate", updateUserAtt
        );
    }

    public Collection<AttributeType> attributeTypes(Map<String, String> attributesAndValues) {
        Set<AttributeType> attributeTypes = new HashSet<>();
        attributesAndValues.forEach((k, v) -> attributeTypes.add(AttributeType.builder().name(k).value(v).build()));
        return attributeTypes;
    }

}
