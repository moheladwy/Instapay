package logic;
import enums.*;
import models.Account;
import models.BankAccount;
import models.WalletAccount;

public class Payment {
    public static TransactionStatus sendToInstapayAccount(Account sender, Account receiver, double amount) {
        return TransactionStatus.TRANSACTION_FAILED;
    }

    public static TransactionStatus sendToBankAccount(BankAccount sender, BankAccount receiver, double amount) {
        return TransactionStatus.TRANSACTION_FAILED;
    }

    public static TransactionStatus sendToWallet(Account sender, WalletAccount receiver, double amount) {
        return TransactionStatus.TRANSACTION_FAILED;
    }
}
