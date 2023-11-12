package logic;
import enums.*;
import models.*;

public class Authentication {
    public static AuthenticationStatus login(User user) {
        return AuthenticationStatus.LOGIN_FAILED;
    }
    public static AuthenticationStatus register(User user) {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }
    public static AuthenticationStatus sendOTP(User user) {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }
}
