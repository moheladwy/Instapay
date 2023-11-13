package models;
import enums.*;

public class ElectricityBill extends Bill {
    public ElectricityBill(double amount, String paymentNumber) throws Exception {
        super(amount, paymentNumber);
    }
}
