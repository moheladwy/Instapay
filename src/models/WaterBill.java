package models;
import enums.*;

public class WaterBill extends Bill {
    String areaCode;
    String subscriberNumber;
    String subscriberName;

    public WaterBill(double amount, String paymentNumber, String Name) throws Exception {
        super(amount, paymentNumber);
        subscriberName = Name;
        areaCode = paymentNumber.substring(0,3);
        subscriberNumber = paymentNumber.substring(3,9);

    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public String getSubscriberName() {
        return subscriberName;
    }
}
