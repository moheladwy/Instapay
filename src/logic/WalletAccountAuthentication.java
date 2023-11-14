package logic;

import DummyAPIs.InstapayAccountDataAPI;
import DummyAPIs.WalletDataAPI;
import enums.*;
import models.*;

import java.util.Scanner;

public class WalletAccountAuthentication extends Authentication {
    @Override
    protected Account registerAccountInfo(User user) {
        System.out.println("Checking wallet ...");
        if (!WalletDataAPI.isPhoneNumberHasWallet(user.getPhoneNumber())) {
            System.out.println("This phone number doesn't have a wallet!");
            return null;
        }
        System.out.println("Wallet found!");
        return WalletDataAPI.getWallet(user.getPhoneNumber());
    }
}
