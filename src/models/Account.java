package models;
public abstract class Account {
    private double balance, maxAllowedBalance;

    public Account() {
        balance = 0;
        maxAllowedBalance = 100_000;
    }

    public Account(double balance, double maxAllowedBalance) throws Exception {
        setBalance(balance);
        setMaxAllowedBalance(maxAllowedBalance);
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
}
