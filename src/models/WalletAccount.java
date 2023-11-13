package models;
import enums.*;

public class WalletAccount extends Account {
    private WalletType type;
    private WalletProvider provider;

    public WalletAccount() {
        super();
        this.type = null;
        this.provider = null;
    }

    public WalletAccount(String walletNumber, WalletType type, WalletProvider provider,
                         double balance, double maxAllowedBalance) throws Exception {
        super(walletNumber, balance, maxAllowedBalance);
        setProvider(provider);
        setType(type);
    }

    public void setProvider(WalletProvider provider) throws Exception {
        if (provider == null)
            throw new Exception("Provider cannot be null!");
        this.provider = provider;
    }

    public WalletProvider getProvider() {
        return provider;
    }

    public void setType(WalletType type) throws Exception {
        if (type == null)
            throw new Exception("Wallet Type cannot be null!");
        this.type = type;
    }

    public WalletType getType() {
        return type;
    }
}
