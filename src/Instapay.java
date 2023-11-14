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
        int type = chooseAccountType();
        setAttributes(type);
        int operation = chooseOperation();
        AuthenticationStatus status = executeOperation(operation);
    }

    private AuthenticationStatus executeOperation(int operation) {
        AuthenticationStatus status = null;
        switch (operation) {
            case 1 -> status = authentication.login();
            case 2 -> status = authentication.register();
            case 3 -> {
                System.out.println("Thanks for using Instapay!");
                System.exit(0);
                break;
            }
        }
        return status;
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

    private int chooseAccountType() {
        System.out.println("Welcome to Instapay!");
        System.out.println("Please choose account type from the following types=>");
        System.out.println("=====================================================");
        System.out.println("1- Bank Account");
        System.out.println("2- Wallet Account");
        System.out.print("Choose account type: ");
        int type = 0;
        while (type == 0) {
            String accountType = System.console().readLine();
            if (accountType.equals("1"))
                type = 1;
            else if (accountType.equals("2"))
                type = 2;
            else
                System.out.println("Invalid choice, Please Enter 1 or 2 only!");
        }
        return type;
    }

    private int chooseOperation() {
        System.out.println("Please choose operation from the following operations=>");
        System.out.println("=======================================================");
        System.out.println("1- Login");
        System.out.println("2- Register");
        System.out.println("3- Exit");
        int operation = 0;
        while (operation == 0) {
            System.out.print("Choose operation: ");
            String operationType = System.console().readLine();
            switch (operationType) {
                case "1" -> operation = 1;
                case "2" -> operation = 2;
                case "3" -> operation = 3;
                default -> System.out.println("Invalid choice, Please Enter 1, 2 or 3 only!");
            }
        }
        return operation;
    }
}
