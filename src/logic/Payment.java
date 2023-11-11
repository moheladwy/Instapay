package logic;
import enums.*;

public class Payment {
    public static TransactionStatus sendToInstapayAccount() {
        return TransactionStatus.TRANSACTION_FAILED;
    }

    public static TransactionStatus sendToBankAccount() {
        return TransactionStatus.TRANSACTION_FAILED;
    }

    public static TransactionStatus sendToWallet() {
        return TransactionStatus.TRANSACTION_FAILED;
    }
}
