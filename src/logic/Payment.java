package logic;
import enums.*;
import models.Account;
import models.BankAccount;
import models.WalletAccount;

public class Payment {
    public static TransactionStatus sendToInstapayAccount(Account sender, Account receiver, double amount) {
        try {
            if (sender == null || receiver == null) {
                return TransactionStatus.TRANSACTION_FAILED;
            }

            if (sender.getBalance() < amount) {
                return TransactionStatus.TRANSACTION_FAILED;
            }

            sender.setBalance(sender.getBalance() - amount);

            receiver.setBalance(receiver.getBalance() + amount);

            return TransactionStatus.TRANSACTION_SUCCESS;
        } catch (Exception e) {
            e.getMessage();
            return TransactionStatus.TRANSACTION_FAILED;
        }
    }

    public static TransactionStatus sendToBankAccount(BankAccount sender, BankAccount receiver, double amount) {
        try {
            if (sender == null || receiver == null) {
                return TransactionStatus.TRANSACTION_FAILED;
            }

            if (sender.getBalance() < amount) {
                return TransactionStatus.TRANSACTION_FAILED;
            }

            sender.setBalance(sender.getBalance() - amount);

            receiver.setBalance(receiver.getBalance() + amount);

            return TransactionStatus.TRANSACTION_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return TransactionStatus.TRANSACTION_FAILED;
        }
    }

    public static TransactionStatus sendToWallet(Account sender, WalletAccount receiver, double amount) {
        try {
            if (sender == null || receiver == null) {
                return TransactionStatus.TRANSACTION_FAILED;
            }

            if (sender.getBalance() < amount) {
                return TransactionStatus.TRANSACTION_FAILED;
            }

            sender.setBalance(sender.getBalance() - amount);

            receiver.setBalance(receiver.getBalance() + amount);

            return TransactionStatus.TRANSACTION_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return TransactionStatus.TRANSACTION_FAILED;
        }
    }
}
