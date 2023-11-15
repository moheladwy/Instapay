import DummyAPIs.BankAccountDataAPI;
import DummyAPIs.BillsDataAPI;
import DummyAPIs.InstapayAccountDataAPI;
import DummyAPIs.WalletDataAPI;
import enums.AuthenticationStatus;
import logic.*;
import models.*;


import java.util.Scanner;

public class Instapay {
    private Authentication authentication;
    private Account account;
    private User user;

    private InstapayAccountDataAPI InstapayAPI;

    private BankAccountDataAPI BankAPI;

    private BillsDataAPI BillsAPI;

    private WalletDataAPI WalletAPI;

    public Instapay() throws Exception {
        this.authentication = null;
        this.account = null;
        user = new User();
        InstapayAPI = new InstapayAccountDataAPI();
        BankAPI = new BankAccountDataAPI();
        BillsAPI = new BillsDataAPI();
        WalletAPI = new WalletDataAPI();
    }

    public static void main(String[] args) {
        try {
            Instapay instapay = new Instapay();
            instapay.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void start() throws Exception {
        int accountType = UI.chooseAccountType();
        setAttributes(accountType);

        int authenticationType = UI.chooseAuthenticationType();
        executeAuthenticationMethod(authenticationType);

        while (true) {
            int operation = UI.chooseOperation();
            switch (operation) {
                case 1: {
                    int option = UI.chooseTransactionType();
                    executeMoneyTransaction(option);
                }
                case 2: {
                    int option = UI.chooseBillType();
                    executePayingBills(option);
                }
                case 3: checkBalance();
                case 4: {
                    System.out.println("Thanks for using Instapay!");
                    System.exit(0);
                }
            }
        }
    }

    private void executeMoneyTransaction(int option) {
        switch (option) {
            case 1: executeInstapayTransaction();
            case 2: executeBankAccountTransaction();
            case 3: executeWalletTransaction();
            case 4: break;
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
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executePayingBills(int option) {
        switch (option) {
            case 1: executeElectricityBillPayment();
            case 2: executeWaterBillPayment();
            case 3: executeGasBillPayment();
            case 4: break;
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
        AuthenticationStatus status = null;
        switch (operation) {
            case 1 -> {
                status = authentication.login();
                if (status == AuthenticationStatus.LOGIN_FAILED) {
                    System.out.println("Invalid username or password, Try again later!");
                    System.exit(0);
                }
                else if (status == AuthenticationStatus.NOT_HAVE_ACCOUNT) {
                    System.out.println("You don't have an account, Please register first!");
                    System.exit(0);
                }
            }
            case 2 -> {
                status = authentication.register();
                if (status == AuthenticationStatus.REGISTRATION_FAILED) {
                    System.out.println("Registration failed, Try again later!");
                    System.exit(0);
                }
                else if (status == AuthenticationStatus.ALREADY_HAVE_ACCOUNT) {
                    System.out.println("You already have an account, Please login!");
                    System.exit(0);
                }
            }
            case 3 -> {
                System.out.println("Thanks for using Instapay!");
                System.exit(0);
            }
        }
    }

    private void setAttributes(int type) {
        account = (type == 1) ? new BankAccount() : new WalletAccount();
        authentication = (type == 1) ? new BankAccountAuthentication() : new WalletAccountAuthentication();
        user = new User();
        try {
            user.setAccount(account);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
