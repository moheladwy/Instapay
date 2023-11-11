package models;
import enums.*;

public class WaterBill extends Bill {
    public WaterBill(BillType type, double amount, String paymentNumber) throws Exception {
        super(type, amount, paymentNumber);
    }
}
