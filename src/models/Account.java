package models;
public abstract class Account {
    private double balance, maxAllowedBalance;
    private String phoneNumber;

    public Account() {
        balance = 0;
        maxAllowedBalance = 100_000;
        phoneNumber = null;
    }

    public Account(String phoneNumber, double balance, double maxAllowedBalance) throws Exception {
        setBalance(balance);
        setMaxAllowedBalance(maxAllowedBalance);
        setPhoneNumber(phoneNumber);
    }

    private void setMaxAllowedBalance(double maxAllowedBalance) throws Exception {
        if (maxAllowedBalance < 100_000)
            throw new Exception("Max Allowed Balance cannot be less than 100,000 !");
        this.maxAllowedBalance = maxAllowedBalance;
    }

    public double getMaxAllowedBalance() {
        return maxAllowedBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws Exception {
        if (balance < 0 || balance > maxAllowedBalance)
            throw new Exception("Balance cannot be less than 0 or bigger than " + maxAllowedBalance + "!");
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber == null)
            throw new Exception("Phone Number cannot be null!");
        if (phoneNumber.length() != 11)
            throw new Exception("Phone Number must be 11 digits!");
        if (!phoneNumber.startsWith("010") && !phoneNumber.startsWith("011") &&
                !phoneNumber.startsWith("012") && !phoneNumber.startsWith("015"))
            throw new Exception("Phone Number must start with 010, 011, 012, or 015!");
        this.phoneNumber = phoneNumber;
    }
}
