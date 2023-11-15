package models;
import enums.*;

public class WalletAccount extends Account {
    private WalletType type;
    private WalletProvider provider;

    public WalletAccount() {
        super();
        this.type = null;
        this.provider = null;
        this.accountType = AccountType.Wallet;
    }

    public WalletAccount(String walletNumber, WalletType type, WalletProvider provider,
                         double balance, double maxAllowedBalance) throws Exception {
        super(walletNumber, balance, maxAllowedBalance);
        setProvider(provider);
        setType(type);
        this.accountType = AccountType.Wallet;
    }

    private void setProvider(WalletProvider provider) throws NullPointerException {
        if (provider == null)
            throw new NullPointerException("Provider cannot be null!");
        this.provider = provider;
    }

    public WalletProvider getProvider() {
        return provider;
    }

    private void setType(WalletType type) throws NullPointerException {
        if (type == null)
            throw new NullPointerException("Wallet Type cannot be null!");
        this.type = type;
    }

    public WalletType getType() {
        return type;
    }
}
