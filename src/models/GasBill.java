package models;
import enums.*;

public class GasBill extends Bill {
    String governmentCode;
    String areaCode;
    String sectorNumber;
    String buildingNumber;
    String apartmentNumber;
    String subscriberName;
    public GasBill(double amount, String paymentNumber, String Name) throws Exception {
        super(amount, paymentNumber);
        subscriberName = Name;
        governmentCode = paymentNumber.substring(0,2);
        areaCode = paymentNumber.substring(2,4);
        sectorNumber = paymentNumber.substring(6,8);
        buildingNumber = paymentNumber.substring(8,12);
        apartmentNumber = paymentNumber.substring(12,16);
    }

    public String getGovernmentCode() {
        return governmentCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getSectorNumber() {
        return sectorNumber;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getSubscriberName() {
        return subscriberName;
    }
}
