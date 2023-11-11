package models;
import enums.*;

public class ElectricityBill extends Bill {
    public ElectricityBill(BillType type, double amount, String paymentNumber) throws Exception {
        super(type, amount, paymentNumber);
    }
}
