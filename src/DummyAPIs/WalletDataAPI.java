package DummyAPIs;
import models.*;

import java.util.HashMap;

public class WalletDataAPI {
    private HashMap<String, String> WalletData;

    public WalletDataAPI() {
        setWalletData();
    }

    public void addWallet() { }

    public boolean isWalletExist() { return false; }

    private void setWalletData() {
        this.WalletData = new HashMap<>();
    }
}
