package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TransactionId;

    @Column(name = "Amount")
    private double Amount;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Timestamp")
    private LocalDateTime Timestamp;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SourceAccountId")
    private Account sourceAccount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DestinationAccountId")
    private Account destinationAccount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CategoryId")
    private Category Category;



    public Transaction() {
    }

    public Transaction(double amount, String description, LocalDateTime timestamp, Account sourceAccount, Account destinationAccount, Category category) {
        Amount = amount;
        Description = description;
        Timestamp = timestamp;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        Category = category;
    }

    public Long getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Long transactionId) {
        TransactionId = transactionId;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDateTime getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        Timestamp = timestamp;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        Category = category;
    }

}
