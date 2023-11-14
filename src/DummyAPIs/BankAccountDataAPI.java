package DummyAPIs;
import models.*;
import enums.*;
import java.util.*;

public class BankAccountDataAPI {
    // key = AccountNumber.
    private final HashMap<String, BankAccount> bankAccountsData;

    public BankAccountDataAPI() {
        bankAccountsData = new HashMap<>();
        try {
            makeDummyData();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void AddAccount(BankAccount account) throws Exception {
        if (account == null)
            throw new Exception("Account cannot be null!");
        bankAccountsData.put(account.getCardNumber(), account);
    }

    public boolean isPhoneNumberConnected(String accountNumber, String phoneNumber) throws NullPointerException {
        if (accountNumber == null || phoneNumber == null)
            throw new NullPointerException("Account Number and Phone Number cannot be null!");
        return bankAccountsData.containsKey(accountNumber) &&
                bankAccountsData.get(accountNumber).getPhoneNumber().equalsIgnoreCase(phoneNumber);
    }



    public BankAccount getAccount(String accountNumber) throws NullPointerException {
        if (accountNumber == null)
            throw new NullPointerException("Account Number cannot be null!");
        return bankAccountsData.get(accountNumber);
    }

    private void makeDummyData() throws Exception {
        // the account number should be 16 digits starts with 5338 or 4738
        // the phone number should be 11 digits starts with 010, 011, 012, or 015
        // the balance should be between 0 and maxAllowedBalance
        // the maxAllowedBalance should be at least 100,000
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("5338365000020000", CardType.CreditCard, BankProvider.CIB,
                "01000000000", 100_000, 1000_000));
        accounts.add(new BankAccount("5338048300050001", CardType.DebitCard, BankProvider.Misr,
                "01111111111", 50_000, 500_000));
        accounts.add(new BankAccount("5338000000000002", CardType.CreditCard, BankProvider.Alexandria,
                "01222222222", 250_000, 1000_000));
        accounts.add(new BankAccount("5338000000000003", CardType.PrepaidCard, BankProvider.Alahly,
                "01555555555", 10_000, 100_000));
        accounts.add(new BankAccount("4738000000000004", CardType.CreditCard, BankProvider.QNB,
                "01000000000", 1000, 1000_000));
        for (BankAccount account : accounts)
            bankAccountsData.put(account.getCardNumber(), account);
    }
}
