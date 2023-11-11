package models;

public class User {
    private String name, username, password, phoneNumber;
    private Account account;

    public User() {
        this.name = this.username = this.password = this.phoneNumber = null;
        this.account = null;
    }

    public User(String name, String username, String password, String phoneNumber, Account account)
    throws Exception {
        setName(name);
        setAccount(account);
        setUsername(username);
        setPassword(password);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null)
            throw new Exception("Name cannot be null!");
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        if (username == null)
            throw new Exception("Username cannot be null!");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password == null)
            throw new Exception("Password cannot be null!");
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber == null)
            throw new Exception("Phone Number cannot be null!");
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) throws Exception {
        if (account == null)
            throw new Exception("Account cannot be null");
        this.account = account;
    }
}
