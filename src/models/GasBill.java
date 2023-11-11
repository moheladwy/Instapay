package models;
import enums.*;

public class GasBill extends Bill {
    public GasBill(BillType type, double amount, String paymentNumber) throws Exception {
        super(type, amount, paymentNumber);
    }
}
