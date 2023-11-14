package logic;

import DummyAPIs.InstapayAccountDataAPI;
import enums.*;
import models.*;

import java.util.Scanner;

public abstract class Authentication {
    public AuthenticationStatus register(){
        // Step 1: Register personal info
        User user = registerPersonalInfo();
        if(user == null)
            return AuthenticationStatus.REGISTRATION_FAILED;

        // Step 2: Register account info (Override this method in subclasses)
        Account account = registerAccountInfo(user);
        if (account == null)
            return AuthenticationStatus.REGISTRATION_FAILED;

        // Step 3: Add account to Database
        user.setAccount(account);
        InstapayAccountDataAPI.addAccount(user);
        return AuthenticationStatus.REGISTRATION_SUCCESS;
    }

    public AuthenticationStatus login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = InstapayAccountDataAPI.getAccount(username, password);

        if (user == null) {
            System.out.println("Invalid username or password!");
            return AuthenticationStatus.LOGIN_FAILED;
        }
        return AuthenticationStatus.LOGIN_SUCCESS;
    }

    protected abstract Account registerAccountInfo(User user);

    public boolean sendOTP(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the OTP sent to this phone number " + user.getPhoneNumber() + ": ");
        String OTP = scanner.nextLine();
        while (OTP == null || OTP.isEmpty() || !OTP.matches("[0-9]{6}")) {
            System.out.println("Invalid OTP format, Try again!");
            OTP = scanner.nextLine();
        }
        System.out.println("OTP is correct!");
        return true;
    }

    protected User registerPersonalInfo(){
        System.out.println("Enter your personal information=>");
        User user = takeUserInfoInput();
        if (InstapayAccountDataAPI.isUsernameExists(user.getUsername())) {
            System.out.println("Username already exists!");
            return null;
        }
        return sendOTP(user) ? user : null;
    }

    private User takeUserInfoInput() throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your full name: ");
        String name = scanner.nextLine();
        while (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty, Try again!");
            System.out.print("Please enter your full name: ");
            name = scanner.nextLine();
        }

        System.out.print("Please enter your phone number:");
        String phoneNumber = scanner.nextLine();
        while (phoneNumber == null || phoneNumber.isEmpty() || !phoneNumber.matches("01[0125][0-9]{8}")) {
            System.out.println("Invalid phone number!");
            System.out.print("Please enter your phone number:");
            phoneNumber = scanner.nextLine();
        }

        System.out.print("Please enter your username:");
        String username = scanner.nextLine();
        while (username == null || username.isEmpty() || !username.matches("^[a-zA-Z0-9._-]{3,}$")) {
            System.out.println("Invalid username!, username must be at least 3 characters " +
                    "and can contain letters, numbers, dots, underscores, and dashes.");
            System.out.print("Please enter your username:");
            username = scanner.nextLine();
        }

        System.out.print("Please enter your password:");
        String password = scanner.nextLine();
        while (password == null || password.isEmpty()
                || !password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            System.out.println("Invalid password!, password must be at least 8 characters " +
                    "and must contain at least one digit, one upper case, one lower case, and one special character.");
            System.out.print("Please enter your password: ");
            password = scanner.nextLine();
        }
        return new User(name, username, password, phoneNumber);
    }
}
