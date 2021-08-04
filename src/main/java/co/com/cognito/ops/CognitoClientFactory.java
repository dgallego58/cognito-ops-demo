package co.com.cognito.ops;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;

public enum CognitoClientFactory {

    LOCAL_INSTANCE {
        @Override
        public CognitoIdentityProviderClient client() {
            return CognitoIdentityProviderClient.builder()
                    .credentialsProvider(DefaultCredentialsProvider.create())
                    .region(Region.US_EAST_1)
                    .build();
        }

        @Override
        public UserPoolDetails details() {
            String systemUserPoolId = System.getenv("userPoolId");
            String systemUserPoolClientId = System.getenv("userPoolClientId");
            return UserPoolDetails.from(systemUserPoolId, systemUserPoolClientId);
        }
    };

    public abstract CognitoIdentityProviderClient client();
    public abstract UserPoolDetails details();

}
