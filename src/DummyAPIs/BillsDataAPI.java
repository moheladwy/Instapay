package DummyAPIs;

import models.BankAccount;
import models.Bill;
import models.ElectricityBill;
import models.WaterBill;
import models.GasBill;

import java.util.HashMap;

public class BillsDataAPI {
    private static HashMap<String, WaterBill> waterBillsData;
    private static HashMap<String, ElectricityBill> electricityBillsData;
    private static HashMap<String, GasBill> gasBillsData;

    public BillsDataAPI() throws Exception {
        waterBillsData = new HashMap<>();
        electricityBillsData = new HashMap<>();
        gasBillsData = new HashMap<>();
        makeDummyData();
    }

    public WaterBill getWaterBill(String paymentCode) throws NullPointerException {
        if (paymentCode == null)
            throw new NullPointerException("Payment code cannot be null!");
        return waterBillsData.get(paymentCode);
    }

    public GasBill getGasBill(String paymentCode) throws NullPointerException {
        if (paymentCode == null)
            throw new NullPointerException("Payment code cannot be null!");
        return gasBillsData.get(paymentCode);
    }

    public ElectricityBill getElectricityBill(String paymentCode) throws NullPointerException {
        if (paymentCode == null)
            throw new NullPointerException("Payment code cannot be null!");
        return electricityBillsData.get(paymentCode);
    }

    private void makeDummyData() throws Exception {
        //water bill consists of 9 digits: first 3 digits is the area code and last 6 is subscriber number
        waterBillsData.put("190", new WaterBill(190, "487121898","Mohamed"));
        waterBillsData.put("200", new WaterBill(200, "487121565", "Ahmed"));
        waterBillsData.put("210", new WaterBill(210, "348121898", "Mahmoud"));

        //electricity bill consists of 12 digits: first 3 digits is the area code and last 9 is subscriber number
        electricityBillsData.put("400", new ElectricityBill(400, "01476893651276", "omar"));
        electricityBillsData.put("410", new ElectricityBill(410, "01476893656844", "qasem"));
        electricityBillsData.put("600", new ElectricityBill(600, "01476899856734", "mohamed"));

        /*gas bill consists of 16 digits: first 2 are the government code then 2 digits area code then 2 digits
        area code then 2 digits sector number then 4 digits building number and last 4 are apartment number.
         */
        gasBillsData.put("50", new GasBill(50, "0130363850050008", "Ahmed"));
        gasBillsData.put("60", new GasBill(60, "0130353850070014", "Mohamed"));
        gasBillsData.put("70", new GasBill(70, "0130343190050009", "Ali"));
    }
}