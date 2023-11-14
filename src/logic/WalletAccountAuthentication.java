package logic;
import enums.*;
import models.*;

public class WalletAccountAuthentication extends Authentication {
    public AuthenticationStatus register(User user) {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }
    public AuthenticationStatus login(User user) {
        return AuthenticationStatus.LOGIN_FAILED;
    }

    @Override
    public AuthenticationStatus register() {
        return null;
    }

    @Override
    public AuthenticationStatus login() {
        return null;
    }
}
