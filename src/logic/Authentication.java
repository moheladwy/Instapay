package logic;
import enums.*;
import models.*;

public abstract class Authentication {
    public abstract AuthenticationStatus login(User user);
    public abstract AuthenticationStatus register(User user);
    public static AuthenticationStatus sendOTP(User user) {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }
}
