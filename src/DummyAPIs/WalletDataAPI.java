package DummyAPIs;

import enums.*;
import models.*;

import java.util.*;

public class WalletDataAPI {
    // key = PhoneNumber.
    private static HashMap<String, WalletAccount> walletData;

    public WalletDataAPI() {
        walletData = new HashMap<>();
        try {
            makeDummyData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addWallet(WalletAccount account) throws Exception {
        if (account == null)
            throw new Exception("Account cannot be null!");
        walletData.put(account.getPhoneNumber(), account);
    }

    public static boolean isPhoneNumberHasWallet(String phoneNumber) throws NullPointerException {
        if (phoneNumber == null)
            throw new NullPointerException("Phone Number cannot be null!");
        return walletData.get(phoneNumber) != null;
    }

    public static WalletAccount getWallet(String phoneNumber) throws NullPointerException {
        if (phoneNumber == null)
            throw new NullPointerException("Phone Number cannot be null!");
        return walletData.get(phoneNumber);
    }

    public static void makeDummyData() throws Exception {
        // the phone number should be 11 digits starts with 010, 011, 012, or 015
        List<WalletAccount> accounts = new ArrayList<>();
        accounts.add(new WalletAccount("01111111111", WalletType.Bank,
                WalletProvider.CIB, 1100, 25_000));
        accounts.add(new WalletAccount("01000000001", WalletType.Telecom,
                WalletProvider.Vodafone, 2000, 25_000));
        accounts.add(new WalletAccount("01222222222", WalletType.Telecom,
                WalletProvider.Orange, 3000, 25_000));
        accounts.add(new WalletAccount("01000000000", WalletType.Bank,
                WalletProvider.QNB, 20_000, 25_000));
        for (WalletAccount account : accounts)
            walletData.put(account.getPhoneNumber(), account);
    }
}
