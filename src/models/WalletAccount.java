package models;
import enums.*;

public class WalletAccount extends Account {
    private String walletNumber;
    private WalletType type;
    private WalletProvider provider;

    public WalletAccount(String walletNumber, WalletType type, WalletProvider provider,
                         double balance, double maxAllowedBalance) throws Exception {
        super(balance, maxAllowedBalance);
        setWalletNumber(walletNumber);
        setProvider(provider);
        setType(type);
    }

    private void setProvider(WalletProvider provider) throws Exception {
        if (provider == null)
            throw new Exception("Provider cannot be null!");
        this.provider = provider;
    }

    public WalletProvider getProvider() {
        return provider;
    }

    private void setWalletNumber(String walletNumber) throws Exception {
        if (walletNumber == null)
            throw new Exception("Wallet Number cannot be null!");
        this.walletNumber = walletNumber;
    }

    public String getWalletNumber() {
        return walletNumber;
    }

    private void setType(WalletType type) throws Exception {
        if (type == null)
            throw new Exception("Wallet Type cannot be null!");
        this.type = type;
    }

    public WalletType getType() {
        return type;
    }
}
