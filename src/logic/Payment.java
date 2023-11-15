package logic;
import enums.*;
import models.*;

public class Payment {
    public static TransactionStatus sendToInstapayAccount(Account sender, Account receiver, double amount) {
        try {
            if (sender == null || receiver == null)
                return TransactionStatus.TRANSACTION_FAILED;
            if (sender.getBalance() < amount)
                return TransactionStatus.TRANSACTION_FAILED;
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
            if (sender == null || receiver == null)
                return TransactionStatus.TRANSACTION_FAILED;
            if (sender.getBalance() < amount)
                return TransactionStatus.TRANSACTION_FAILED;
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
            if (sender == null || receiver == null)
                return TransactionStatus.TRANSACTION_FAILED;
            if (sender.getBalance() < amount)
                return TransactionStatus.TRANSACTION_FAILED;
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            return TransactionStatus.TRANSACTION_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return TransactionStatus.TRANSACTION_FAILED;
        }
    }

    public static void payBill(Account account, Bill bill, double amount) {
        try {
            if (account == null || bill == null)
                throw new Exception("Account or bill cannot be null!");
            if (account.getBalance() < amount)
                throw new Exception("Insufficient balance!");
            if (amount == 0)
                throw new Exception("No bills yet!");
            account.setBalance(account.getBalance() - amount);
            bill.setAmount(bill.getAmount() - amount);
            System.out.println("Bill paid successfully!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
