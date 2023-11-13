package models;
import enums.*;

public class WaterBill extends Bill {
    private String areaCode;
    private String subscriberNumber;
    private String subscriberName;

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

    public void setSubscriberName(String name) throws Exception {
        if (name == null)
            throw new Exception("Name cannot be null!");
        subscriberName = name;
    }

    public void setAreaCode(String code) throws Exception {
        if (code == null)
            throw new Exception("Area Code cannot be null!");
        areaCode = code;
    }

    public void setSubscriberNumber(String number) throws Exception {
        if (number == null)
            throw new Exception("Subscriber Number cannot be null!");
        subscriberNumber = number;
    }
}
