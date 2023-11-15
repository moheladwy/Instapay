import DummyAPIs.BankAccountDataAPI;
import DummyAPIs.InstapayAccountDataAPI;
import DummyAPIs.WalletDataAPI;
import enums.AuthenticationStatus;
import logic.*;
import models.*;

public class Instapay {
    private Authentication authentication;
    private Account account;
    private User user;

    public Instapay() {
        this.authentication = null;
        this.account = null;
        user = new User();
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
                case 3: executeEditPersonalInfo(); // // TODO: Write the implementation.
                case 4: {
                    System.out.println("Thanks for using Instapay!");
                    System.exit(0);
                }
            }
        }
    }

    private void executeMoneyTransaction(int option) {
        switch (option) {
            case 1: {
                executeInstapayTransaction();
                break;
            }
            case 2: {
                executeBankAccountTransaction();
                break;
            }
            case 3: {
                executeWalletTransaction();
                break;
            }
            case 4: break;
        }
    }

    private void executeInstapayTransaction() {
        String receiverUsername = UI.getReceiverUsername();
        if (!InstapayAccountDataAPI.isUsernameExists(receiverUsername))  {
            System.out.println("Username doesn't exist!");
            return;
        }
        Account receiver = InstapayAccountDataAPI.getAccount(receiverUsername);
        double amount = UI.getAmount();
        try {
            Payment.sendToInstapayAccount(user.getAccount(), receiver, amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executeBankAccountTransaction() {
        String receiverBankAccountNumber = UI.getReceiverBankAccountNumber();
        if (!BankAccountDataAPI.isBankAccountExist(receiverBankAccountNumber)) {
            System.out.println("Bank account number doesn't exist!");
            return;
        }
        BankAccount receiverBankAccount = BankAccountDataAPI.getAccount(receiverBankAccountNumber);
        double amount = UI.getAmount();
        try {
            Payment.sendToBankAccount((BankAccount) user.getAccount(), receiverBankAccount, amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void executeWalletTransaction() {
        String receiverPhoneNumber = UI.getReceiverPhoneNumber();
        if (!WalletDataAPI.isPhoneNumberHasWallet(receiverPhoneNumber)) {
            System.out.println("Phone number doesn't exist!");
            return;
        }
        WalletAccount receiverAccount = WalletDataAPI.getWallet(receiverPhoneNumber);
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
        // TODO: Write the implementation.
    }

    private void executeWaterBillPayment() {
        // TODO: Write the implementation.
    }

    private void executeElectricityBillPayment() {
        // TODO: Write the implementation.
    }

    private void executeEditPersonalInfo() {
        // TODO: Write the implementation.
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
