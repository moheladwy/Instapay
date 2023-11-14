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
        System.out.println("Please enter your bank account card number");
        String cardNumber = scanner.nextLine();

        BankAccountDataAPI bankAccountDataAPI = new BankAccountDataAPI();
        BankAccount bankAccount = bankAccountDataAPI.getAccount(cardNumber);
        if (bankAccount == null) {
            System.out.println("Invalid card number!");
            return null;
        } else if (!bankAccountDataAPI.isPhoneNumberConnected(cardNumber, user.getPhoneNumber())) {
            System.out.println("This card number is not connected to this phone number!");
            return null;
        }

        return bankAccount;
    }

}
