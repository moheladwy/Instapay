package models;
import enums.*;

public class BankAccount extends Account {
    private String cardNumber;
    private CardType type;
    private BankProvider provider;

    public BankAccount() {
        super();
        this.cardNumber = null;
        this.type = null;
        this.provider = null;
        this.accountType = AccountType.Bank;
    }

    public BankAccount(String cardNumber, CardType type, BankProvider provider,
            String phoneNumber, double balance, double maxAllowedBalance) throws Exception {
        super(phoneNumber, balance, maxAllowedBalance);
        setCardNumber(cardNumber);
        setProvider(provider);
        setType(type);
        this.accountType = AccountType.Bank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) throws Exception {
        if (cardNumber == null)
            throw new Exception("Card Number cannot be null!");
        this.cardNumber = cardNumber;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) throws Exception {
        if (type == null)
            throw new Exception("Card Type cannot be null!");
        this.type = type;
    }

    public void setProvider(BankProvider provider) throws Exception {
        if (provider == null)
            throw new Exception("Provider cannot be null!");
        this.provider = provider;
    }

    public BankProvider getProvider() {
        return provider;
    }
}
