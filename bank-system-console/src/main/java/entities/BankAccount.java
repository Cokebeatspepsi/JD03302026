package entities;

import java.math.BigDecimal;

public class BankAccount {
    private long id;
    private String accountNumber;
    private BigDecimal balance;
    private Boolean active;

    public BankAccount(){}

    public BankAccount(String accountNumber, BigDecimal initialBalance) {
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Initial Balance cannot be negative");
        }
        this.id = 0;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.active = true;
    }


    public BankAccount(String accountNumber, BigDecimal balance, Boolean active) {
        if (balance.compareTo(BigDecimal.ZERO) >0 ) {
            throw new IllegalArgumentException("Starting balance must be greater than zero");
        }

        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.active = active;

    }
    public void  deposit(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) >=0) {
            throw new RuntimeException("Amount must be greater than zero");
        }
        this.balance.add(amount);
    }

    public void  withdraw(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) >=0) {
            throw new RuntimeException("Amount passed is less than zero");
        }
        if(balance.compareTo(amount) <= 0){
            throw new RuntimeException("Balance must be greater than zero");
        }
        this.balance.subtract(amount);
    }




    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }

    //Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
