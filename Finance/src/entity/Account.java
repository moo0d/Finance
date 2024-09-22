package entity;


import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AccountId;

    @Column(name = "AccountName")
    private String AccountName;

    @Column(name = "Balance")
    private double Balance;

    public Account() {
    }

    public Account(String accountName, double balance) {
        AccountName = accountName;
        Balance = balance;
    }


    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }


}
