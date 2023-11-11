package logic;
import enums.*;

public class Authentication {
    public static AuthenticationStatus login() {
        return AuthenticationStatus.LOGIN_FAILED;
    }
    public static AuthenticationStatus register() {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }
    public static AuthenticationStatus sendOTP() {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }
}
