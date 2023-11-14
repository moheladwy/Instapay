package models;
import enums.*;

public class GasBill extends Bill {
    private String governmentCode;
    private String areaCode;
    private String sectorNumber;
    private String buildingNumber;
    private String apartmentNumber;
    private String subscriberName;

    public GasBill(double amount, String paymentNumber, String Name) throws Exception {
        super(amount, paymentNumber);
    }

    public void setGovernmentCode(String governmentCode) throws Exception{
        if (governmentCode == null)
            throw new Exception("Government Code cannot be null!");
        this.governmentCode = governmentCode;
    }

    public void setAreaCode(String areaCode) throws Exception{
        if (areaCode == null)
            throw new Exception("Area Code cannot be null!");
        this.areaCode = areaCode;
    }

    public void setSectorNumber(String sectorNumber) throws Exception{
        if (sectorNumber == null)
            throw new Exception("Sector Number cannot be null!");
        this.sectorNumber = sectorNumber;
    }

    public void setBuildingNumber(String buildingNumber) throws Exception{
        if (buildingNumber == null)
            throw new Exception("Building Number cannot be null!");
        this.buildingNumber = buildingNumber;
    }

    public void setApartmentNumber(String apartmentNumber) throws Exception{
        if (apartmentNumber == null)
            throw new Exception("Apartment Number cannot be null!");
        this.apartmentNumber = apartmentNumber;
    }

    public void setSubscriberName(String subscriberName) throws Exception{
        if (subscriberName == null)
            throw new Exception("Subscriber Name cannot be null!");
        this.subscriberName = subscriberName;
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
