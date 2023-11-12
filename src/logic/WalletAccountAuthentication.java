package logic;
import enums.*;
import models.*;

public class WalletAccountAuthentication extends Authentication {
    public AuthenticationStatus login(User user) {
        return AuthenticationStatus.LOGIN_FAILED;
    }

    public AuthenticationStatus register(User user) {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }
}
