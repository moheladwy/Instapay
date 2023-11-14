package logic;

import DummyAPIs.BankAccountDataAPI;
import DummyAPIs.InstapayAccountDataAPI;
import enums.*;
import models.*;

import java.util.Scanner;

public class BankAccountAuthentication extends Authentication {
    @Override
    protected Account registerAccountInfo(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your bank account card number: ");
        String cardNumber = scanner.nextLine();

        BankAccount bankAccount = BankAccountDataAPI.getAccount(cardNumber);
        System.out.println("Checking bank account ...");
        if (bankAccount == null) {
            System.out.println("Invalid card number!");
            return null;
        } else if (!BankAccountDataAPI.isPhoneNumberConnected(cardNumber, user.getPhoneNumber())) {
            System.out.println("This card number is not connected to this phone number!");
            return null;
        }
        return bankAccount;
    }

}
