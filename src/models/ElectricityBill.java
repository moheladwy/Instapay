package models;
import enums.*;

public class ElectricityBill extends Bill {
    private String areaCode;
    private String subscriberNumber;
    private String subscriberName;

    public ElectricityBill(double amount, String paymentNumber, String Name) throws Exception {
        super(amount, paymentNumber);
    }

    public void setSubscriberName(String subscriberName) throws Exception {
        if (subscriberName == null)
            throw new Exception("Subscriber Name cannot be null!");
        this.subscriberName = subscriberName;
    }

    public void setAreaCode(String areaCode) throws Exception {
        if (areaCode == null)
            throw new Exception("Area Code cannot be null!");
        this.areaCode = areaCode;
    }

    public void setSubscriberNumber(String subscriberNumber) throws Exception {
        if (subscriberNumber == null)
            throw new Exception("Subscriber Number cannot be null!");
        this.subscriberNumber = subscriberNumber;
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
