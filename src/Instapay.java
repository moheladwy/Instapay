import DummyAPIs.*;
import enums.*;
import logic.*;
import models.*;
import java.util.Scanner;

public class Instapay {
    private Authentication authentication;
    private Account account;
    private User user;
    private final InstapayAccountDataAPI InstapayAPI;
    private final BankAccountDataAPI BankAPI;
    private final BillsDataAPI BillsAPI;
    private final WalletDataAPI WalletAPI;

    public Instapay() throws Exception {
        this.authentication = null;
        this.account = null;
        user = new User();
        InstapayAPI = new InstapayAccountDataAPI();
        BankAPI = new BankAccountDataAPI();
        BillsAPI = new BillsDataAPI();
        WalletAPI = new WalletDataAPI();
    }

    public void start() {
        int authenticationType = UI.chooseAuthenticationType();
        if (authenticationType == 1) {
            authentication = new BankAccountAuthentication();
            account = user.getAccount();
        } else if (authenticationType == 2) {
            int accountType = UI.chooseAccountType();
            if (accountType == 3) exit("Thank you for using Instapay!");
            setAttributes(accountType);
        } else exit("Thank you for using Instapay!");
        executeAuthenticationMethod(authenticationType);

        while (true) {
            int operation = UI.chooseOperation();
            switch (operation) {
                case 1 -> {
                    int option = UI.chooseTransactionType();
                    executeMoneyTransaction(option);
                }
                case 2 -> {
                    int option = UI.chooseBillType();
                    executePayingBills(option);
                }
                case 3 -> checkBalance();
                case 4 -> exit("Thank you for using Instapay!");
            }
        }
    }

    private void setAttributes(int type) {
        account = (type == 1) ? new BankAccount() : new WalletAccount();
        authentication = (type == 1) ? new BankAccountAuthentication() : new WalletAccountAuthentication();
        try {
            user.setAccount(account);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executeMoneyTransaction(int option) {
        switch (option) {
            case 1 -> executeInstapayTransaction();
            case 2 -> {
                if (user.getAccount().getAccountType() == AccountType.Bank)
                    executeBankAccountTransaction();
                else System.out.println("You can't send money to bank account from your wallet!");
            }
            case 3 -> executeWalletTransaction();
            case 4 -> System.out.println("Returning to the main menu...");
            default -> System.out.println("Invalid option!");
        }
    }

    private void executeInstapayTransaction() {
        String receiverUsername = UI.getReceiverUsername();
        if (!InstapayAPI.isUsernameExists(receiverUsername))  {
            System.out.println("Username doesn't exist!");
            return;
        }
        Account receiver = InstapayAPI.getAccount(receiverUsername);
        double amount = UI.getAmount();
        try {
            Payment.sendToInstapayAccount(user.getAccount(), receiver, amount);
            System.out.println("Transaction done successfully!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executeBankAccountTransaction() {
        String receiverBankAccountNumber = UI.getReceiverBankAccountNumber();
        if (!BankAPI.isBankAccountExist(receiverBankAccountNumber)) {
            System.out.println("Bank account number doesn't exist!");
            return;
        }
        BankAccount receiverBankAccount = BankAPI.getAccount(receiverBankAccountNumber);
        double amount = UI.getAmount();
        try {
            Payment.sendToBankAccount((BankAccount) user.getAccount(), receiverBankAccount, amount);
            System.out.println("Transaction done successfully!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executeWalletTransaction() {
        String receiverPhoneNumber = UI.getReceiverPhoneNumber();
        if (!WalletAPI.isPhoneNumberHasWallet(receiverPhoneNumber)) {
            System.out.println("Phone number doesn't exist!");
            return;
        }
        WalletAccount receiverAccount = WalletAPI.getWallet(receiverPhoneNumber);
        double amount = UI.getAmount();
        try {
            Payment.sendToWallet(user.getAccount(), receiverAccount, amount);
            System.out.println("Transaction done successfully!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executePayingBills(int option) {
        switch (option) {
            case 1 -> executeWaterBillPayment();
            case 2 -> executeElectricityBillPayment();
            case 3 -> executeGasBillPayment();
            case 4 -> System.out.println("Returning to the main menu...");
            default -> System.out.println("Invalid option!");
        }
    }

    private void executeGasBillPayment() {
        System.out.print("Enter payment number: ");
        Scanner scanner = new Scanner(System.in);
        String paymentNumber = scanner.nextLine();

        GasBill bill = BillsAPI.getGasBill(paymentNumber);
        if (bill == null) {
            System.out.println("Payment number doesn't exist!");
            return;
        }
        double amount = bill.getAmount();

        try {
            Payment.payBill(user.getAccount(), bill, amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }



    }

    private void executeWaterBillPayment() {
        System.out.print("Enter payment number: ");
        Scanner scanner = new Scanner(System.in);
        String paymentNumber = scanner.nextLine();

        WaterBill bill = BillsAPI.getWaterBill(paymentNumber);
        if (bill == null) {
            System.out.println("Payment number doesn't exist!");
            return;
        }
        double amount = bill.getAmount();
        try {
            Payment.payBill(user.getAccount(), bill, amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executeElectricityBillPayment() {
        System.out.print("Enter payment number: ");
        Scanner scanner = new Scanner(System.in);
        String paymentNumber = scanner.nextLine();

        ElectricityBill bill = BillsAPI.getElectricityBill(paymentNumber);
        if (bill == null) {
            System.out.println("Payment number doesn't exist!");
            return;
        }
        double amount = bill.getAmount();

        try {
            Payment.payBill(user.getAccount(), bill, amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void checkBalance() {
        System.out.println("Your balance is: " + user.getAccount().getBalance());
    }

    private void executeAuthenticationMethod(int operation) {
        if (operation == 1) {
            user = authentication.login();
            if (user == null)
                exit("Invalid username or password, Try again later!");
        } else {
            RegistrationStatus status = authentication.register(user);
            if (status == RegistrationStatus.REGISTRATION_FAILED)
                exit("Registration failed, Try again later!");
            else if (status == RegistrationStatus.ALREADY_HAVE_ACCOUNT)
                exit("You already have an account, Please login!");
        }
    }

    public void exit(String message) {
        System.out.println(message);
        System.exit(0);
    }
}
