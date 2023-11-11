package models;
import enums.*;

public class Bill {
    private BillType type;
    private double amount;
    private String paymentNumber;

    public Bill(BillType type, double amount, String paymentNumber) throws Exception {
        setType(type);
        setAmount(amount);
        setPaymentNumber(paymentNumber);
    }

    public BillType getType() {
        return type;
    }

    public void setType(BillType type) throws Exception {
        if (type == null)
            throw new Exception("Bill Type cannot be null!");
        this.type = type;
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
