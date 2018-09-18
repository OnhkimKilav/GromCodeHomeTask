package lesson20.task2;

import java.util.Date;

/**
 * Created by Valik on 18.09.2018.
 */
public class Transaction {
    private long id;
    private String city;
    private int amount;
    private String description;
    private TransactionType type;
    private Date dateCtreated;

    public Transaction(long id, String city, int amount, String description, TransactionType type, Date dateCtreated) {
        this.id = id;
        this.city = city;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.dateCtreated = dateCtreated;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getDateCtreated() {
        return dateCtreated;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", dateCtreated=" + dateCtreated +
                '}';
    }
}
