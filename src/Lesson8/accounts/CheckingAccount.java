package Lesson8.accounts;

/**
 * Created by Valik on 16.02.2018.
 */
public class CheckingAccount extends Account {
    int limitOFExpenses;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOFExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOFExpenses = limitOFExpenses;
    }

    void withdraw(int amount) {
        if (amount > limitOFExpenses)
            return;
        moneyAmount -= amount;
    }
}
