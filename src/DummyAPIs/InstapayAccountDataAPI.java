package DummyAPIs;

import models.*;
import enums.*;

import java.util.HashMap;

public class InstapayAccountDataAPI {
    // key: username
    private static HashMap<String, User> accounts;

    public InstapayAccountDataAPI() {
        accounts = new HashMap<>();
        try {
            makeDummyData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  void addAccount(User user) throws NullPointerException {
        if (user == null)
            throw new NullPointerException("User cannot be null!");
        accounts.put(user.getUsername(), user);
    }

    public  boolean isUsernameExists(String username)  {
        if (username == null)
            return false;
        return accounts.containsKey(username);
    }

    public  User getUser(String username, String password) {
        if (username == null || password == null)
            return null;
        return accounts.get(username);
    }

    public  Account getAccount(String username) {
        if (username == null)
            return null;
        User user = accounts.get(username);
        if (user == null || !user.getUsername().equals(username))
            return null;
        return user.getAccount();
    }

    private static void makeDummyData() throws Exception {
        accounts.put("user1", new User("user1", "user1", "User1@instapay", "01000000000",
                new WalletAccount("01000000000", WalletType.Bank, WalletProvider.CIB, 1000, 1000_000)));
        accounts.put("user2", new User("user2", "user2", "User2@instapay", "01111111111",
                new WalletAccount("01111111111", WalletType.Telecom, WalletProvider.Vodafone, 1000, 1000_000)));
        accounts.put("user3", new User("user3", "user3", "User3@instapay", "01222222222",
                new WalletAccount("01222222222", WalletType.Telecom, WalletProvider.Orange, 1000, 1000_000)));
        accounts.put("user4", new User("user4", "user4", "User4@instapay", "01555555555",
                new BankAccount("5338365000020000", CardType.CreditCard, BankProvider.CIB, "01555555555", 1000, 1000_000)));
        accounts.put("user5", new User("user5", "user5", "User5@instapay", "01000000001",
                new BankAccount("5338048300050001", CardType.DebitCard, BankProvider.Misr, "01000000001", 1000, 1000_000)));
    }
}
