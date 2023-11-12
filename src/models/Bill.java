package models;
import enums.*;

public class Bill {
    private double amount;
    private String paymentNumber;

    public Bill(double amount, String paymentNumber) throws Exception {
        setAmount(amount);
        setPaymentNumber(paymentNumber);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws Exception {
        if (amount < 0)
            throw new Exception("Amount cannot be less than 0!");
        this.amount = amount;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    private void setPaymentNumber(String paymentNumber) throws Exception {
        if (paymentNumber == null)
            throw new Exception("Bill Type cannot be null!");
        this.paymentNumber = paymentNumber;
    }
}
