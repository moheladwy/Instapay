package logic;

import DummyAPIs.InstapayAccountDataAPI;
import DummyAPIs.WalletDataAPI;
import enums.*;
import models.*;

import java.util.Scanner;

public class WalletAccountAuthentication extends Authentication {
    @Override
    protected Account registerAccountInfo(User user) {
        System.out.println("Checking wallet...");
        WalletDataAPI walletDataAPI = new WalletDataAPI();
        if (!walletDataAPI.isPhoneNumberHasWallet(user.getPhoneNumber())) {
            System.out.println("This phone number is not connected to any wallet!");
            return null;
        }
        System.out.println("Wallet found!");
        return walletDataAPI.getWallet(user.getPhoneNumber());
    }
}
