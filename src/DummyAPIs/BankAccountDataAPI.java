package DummyAPIs;
import models.*;
import java.util.HashMap;

public class BankAccountDataAPI {
    // key = AccountNumber, Value = PhoneNumber
    private HashMap<String, String> backAccountsData;

    public BankAccountDataAPI() {
        setBackAccountsData();
    }

    public void AddAccount() { }

    public boolean isPhoneNumberConnected(String AccountNumber, String PhoneNumber) { return false; }

    private void setBackAccountsData() {
        this.backAccountsData = new HashMap<>();
    }
}
