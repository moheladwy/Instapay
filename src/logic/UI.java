package logic;

import java.util.Scanner;

public class UI {
    private static void accountTypeMenu() {
        System.out.println("=====================================================");
        System.out.println("Welcome to Instapay!");
        System.out.println("Please choose account type from the following types=>");
        System.out.println("=====================================================");
        System.out.println("1- Bank Account");
        System.out.println("2- Wallet Account");
    }

    private static void authenticationMenu() {
        System.out.println("=======================================================");
        System.out.println("Please choose operation from the following operations=>");
        System.out.println("=======================================================");
        System.out.println("1- Login");
        System.out.println("2- Register");
        System.out.println("3- Exit");
    }

    private static void optionsMenu() {
        System.out.println("=======================================================");
        System.out.println("Please choose operation from the following operations=>");
        System.out.println("=======================================================");
        System.out.println("1- Send Money");
        System.out.println("2- Pay Bills");
        System.out.println("3- Inquire Balance");
        System.out.println("4- Exit");
    }

    private static void sendMoneyMenu() {
        System.out.println("choose operation from the following operations=>");
        System.out.println("================================================");
        System.out.println("1- Send Money to Instapay Account");
        System.out.println("2- Send Money to Bank Account");
        System.out.println("3- Send Money to Wallet");
        System.out.println("4- Return to the Main Menu");
    }

    private static void payBillsMenu() {
        System.out.println("choose operation from the following operations=>");
        System.out.println("================================================");
        System.out.println("1- Pay Water Bill");
        System.out.println("2- Pay Gas Bill");
        System.out.println("3- Pay Electricity Bill");
        System.out.println("4- Return to the Main Menu");
    }

    private static void editPersonalInfoMenu() {
        System.out.println("choose operation from the following operations=>");
        System.out.println("================================================");
        System.out.println("1- Edit Full Name");
        System.out.println("2- Edit Password");
        System.out.println("3- Edit Account Type");
        System.out.println("4- Return to the Main Menu");
    }

    public static int chooseOperation() {
        UI.optionsMenu();
        int operation = 0;
        Scanner scanner = new Scanner(System.in);
        while (operation == 0) {
            System.out.print("Choose operation: ");
            String operationType = scanner.nextLine();
            switch (operationType) {
                case "1" -> operation = 1;
                case "2" -> operation = 2;
                case "3" -> operation = 3;
                case "4" -> operation = 4;
                default -> System.out.println("Invalid choice, Please Enter 1, 2, 3 or 4 only!");
            }
        }
        return operation;
    }

    public static int chooseAccountType() {
        UI.accountTypeMenu();
        int type = 0;
        Scanner scanner = new Scanner(System.in);
        while (type == 0) {
            System.out.print("Choose account type: ");
            String accountType = scanner.nextLine();
            switch (accountType) {
                case "1" -> type = 1;
                case "2" -> type = 2;
                default -> System.out.println("Invalid choice, Please Enter 1 or 2 only!");
            }
        }
        return type;
    }

    public static int chooseAuthenticationType() {
        UI.authenticationMenu();
        int operation = 0;
        Scanner scanner = new Scanner(System.in);
        while (operation == 0) {
            System.out.print("Choose operation: ");
            String operationType = scanner.nextLine();
            switch (operationType) {
                case "1" -> operation = 1;
                case "2" -> operation = 2;
                case "3" -> operation = 3;
                default -> System.out.println("Invalid choice, Please Enter 1, 2 or 3 only!");
            }
        }
        return operation;
    }

    public static int chooseTransactionType() {
        UI.sendMoneyMenu();
        int operation = 0;
        Scanner scanner = new Scanner(System.in);
        while (operation != 4) {
            System.out.print("Choose operation: ");
            String operationType = scanner.nextLine();
            switch (operationType) {
                case "1" -> operation = 1;
                case "2" -> operation = 2;
                case "3" -> operation = 3;
                case "4" -> operation = 4;
                default -> System.out.println("Invalid choice, Please Enter 1, 2, 3 or 4 only!");
            }
        }
        return operation;
    }

    public static int chooseBillType() {
        payBillsMenu();
        int operation = 0;
        Scanner scanner = new Scanner(System.in);
        while (operation != 4) {
            System.out.print("Choose operation: ");
            String operationType = scanner.nextLine();
            switch (operationType) {
                case "1" -> operation = 1;
                case "2" -> operation = 2;
                case "3" -> operation = 3;
                case "4" -> operation = 4;
                default -> System.out.println("Invalid choice, Please Enter 1, 2, 3 or 4 only!");
            }
        }
        return operation;
    }

    public static String getReceiverUsername() {
        Scanner scanner = new Scanner(System.in);
        String username = null;
        while (username == null || username.isEmpty()) {
            System.out.print("Enter receiver's username: ");
            username = scanner.nextLine();
            if (username == null || username.isEmpty())
                System.out.println("Invalid username, Please try again!");
        }
        return username;
    }

    public static String getReceiverBankAccountNumber() {
        Scanner scanner = new Scanner(System.in);
        String receiverBankAccountNumber = null;
        boolean notValid = true;
        while (notValid) {
            System.out.print("Enter receiver's bank account number: ");
            receiverBankAccountNumber = scanner.nextLine();
            notValid = receiverBankAccountNumber == null || !receiverBankAccountNumber.matches("^(5338|4738)[0-9]{14}$");
            if (notValid)
                System.out.println("Invalid bank account number, Please try again!");
        }
        return receiverBankAccountNumber;
    }

    public static String getReceiverPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String receiverPhoneNumber = null;
        boolean notValid = true;
        while (notValid) {
            System.out.println("Enter receiver's phone number: ");
            receiverPhoneNumber = scanner.nextLine();
            notValid = receiverPhoneNumber == null || !receiverPhoneNumber.matches("^(010|011|012|015)[0-9]{8}$");
            if (notValid)
                System.out.println("Invalid phone number, Please try again!");
        }
        return receiverPhoneNumber;
    }

    public static double getAmount() {
        Scanner scanner = new Scanner(System.in);
        double amount = -1;
        while (amount < 1) {
            System.out.print("Enter amount: ");
            amount = scanner.nextDouble();
            if (amount < 1)
                System.out.println("Invalid amount, Please try again!");
        }
        return amount;
    }
}
