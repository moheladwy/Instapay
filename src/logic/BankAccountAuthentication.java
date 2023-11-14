package logic;

import DummyAPIs.BankAccountDataAPI;
import DummyAPIs.InstapayAccountDataAPI;
import enums.*;
import models.*;

import java.util.Scanner;

public class BankAccountAuthentication extends Authentication {
    public AuthenticationStatus register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your personal information:");
        User user = takeUserInfoInput();
        if (new InstapayAccountDataAPI().isUsernameExists(user.getUsername())) {
            System.out.println("Username already exists!");
            return AuthenticationStatus.REGISTRATION_FAILED;
        }

        System.out.println("Please enter your bank account card number");
        String cardNumber = scanner.nextLine();

        BankAccount bankAccount;
        try {
            bankAccount = new BankAccountDataAPI().getAccount(cardNumber);
        } catch (Exception e) {
            System.out.println("Invalid card number!");
            return AuthenticationStatus.REGISTRATION_FAILED;
        }

        user.setAccount(bankAccount);
        new InstapayAccountDataAPI().addAccount(user);
        return AuthenticationStatus.REGISTRATION_SUCCESS;
    }

    public AuthenticationStatus login() {
        return AuthenticationStatus.LOGIN_FAILED;
    }

//    private BankAccount takeBankAccountInfoInput() throws NullPointerException {
//        Scanner scanner = new Scanner(System.in);
//        // Get card number from user
//        System.out.println("Please enter your card number:");
//        String cardNumber = scanner.nextLine();
//
//        // Print all card types and get user input
//        System.out.println("Please enter your card type:");
//        CardType[] cardTypes = CardType.values();
//        for (int i = 0; i < cardTypes.length; i++)
//            System.out.println((i + 1) + "- " + cardTypes[i]);
//        CardType cardType = takeCardTypeInput(cardTypes);
//
//        // Print all bank providers and get user input
//        System.out.println("Please enter your bank provider:");
//        BankProvider[] bankProviders = BankProvider.values();
//        for (int i = 0; i < bankProviders.length; i++)
//            System.out.println((i + 1) + "- " + bankProviders[i]);
//        BankProvider bankProvider = takeBankProviderInput(bankProviders);
//
//        return new BankAccount(cardNumber, cardType, bankProvider, null, 0, 0);
//    }

//    private CardType takeCardTypeInput(CardType[] cardTypes) {
//        int cardTypeIndex;
//        CardType cardType;
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            try {
//                cardTypeIndex = scanner.nextInt();
//                if (cardTypeIndex < 1 || cardTypeIndex > cardTypes.length)
//                    throw new Exception();
//                cardType = cardTypes[cardTypeIndex - 1];
//                break;
//            } catch (Exception e) {
//                System.out.println("Invalid card type number!");
//            }
//        }
//        return cardType;
//    }
//
//    private BankProvider takeBankProviderInput(BankProvider[] bankProviders) {
//        int bankProviderIndex;
//        BankProvider bankProvider;
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            try {
//                bankProviderIndex = scanner.nextInt();
//                if (bankProviderIndex < 1 || bankProviderIndex > bankProviders.length)
//                    throw new Exception();
//                bankProvider = bankProviders[bankProviderIndex - 1];
//                break;
//            } catch (Exception e) {
//                System.out.println("Invalid bank provider number!");
//            }
//        }
//        return bankProvider;
//    }
}
