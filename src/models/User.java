package models;

public class User {
    private String name, username, password, phoneNumber;
    private Account account;

    public User() {
        this.name = this.username = this.password = this.phoneNumber = null;
        this.account = null;
    }

    public User(String name, String username, String password, String phoneNumber)
            throws NullPointerException {
        setName(name);
        setUsername(username);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        this.account = null;
    }

    public User(String name, String username, String password, String phoneNumber, Account account)
            throws Exception {
        this(name, username, password, phoneNumber);
        setAccount(account);
    }

    public void copy (User user) {
        this.name = user.name;
        this.username = user.username;
        this.password = user.password;
        this.phoneNumber = user.phoneNumber;
        this.account = user.account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
        if (name == null)
            throw new NullPointerException("Name cannot be null!");
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws NullPointerException {
        if (username == null)
            throw new NullPointerException("Username cannot be null!");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NullPointerException {
        if (password == null)
            throw new NullPointerException("Password cannot be null!");
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws NullPointerException {
        if (phoneNumber == null)
            throw new NullPointerException("Phone Number cannot be null!");
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) throws NullPointerException {
        if (account == null)
            throw new NullPointerException("Account cannot be null");
        this.account = account;
    }
}
