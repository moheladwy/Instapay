package logic;

import DummyAPIs.InstapayAccountDataAPI;
import enums.*;
import models.*;

import java.util.Scanner;

public abstract class Authentication {
    public abstract AuthenticationStatus register();

    public abstract AuthenticationStatus login();

    public static AuthenticationStatus sendOTP(User user) {
        return AuthenticationStatus.REGISTRATION_FAILED;
    }

    protected User takeUserInfoInput() throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your full name:");
        String name = scanner.nextLine();
        while (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            name = scanner.nextLine();
        }

        System.out.println("Please enter your phone number:");
        String phoneNumber = scanner.nextLine();
        while (phoneNumber == null || phoneNumber.isEmpty() || !phoneNumber.matches("01[0125][0-9]{8}")) {
            System.out.println("Invalid phone number!");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        while (username == null || username.isEmpty() || !username.matches("^[a-zA-Z0-9._-]{3,}$")) {
            System.out.println("Invalid username!, username must be at least 3 characters " +
                    "and can contain letters, numbers, dots, underscores, and dashes.");
            username = scanner.nextLine();
        }

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        while (password == null || password.isEmpty()
                || !password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            System.out.println("Invalid password!, password must be at least 8 characters " +
                    "and must contain at least one digit, one upper case, one lower case, and one special character.");
            password = scanner.nextLine();
        }

        return new User(name, username, password, phoneNumber);
    }
}
