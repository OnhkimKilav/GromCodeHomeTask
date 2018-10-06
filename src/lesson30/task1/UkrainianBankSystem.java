package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by User on 26.03.2018.
 */
public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        //проверить можно ли снять - проверить лимит, проверить достаточно ли денег
        //снять деньги

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "withdraw");
    }

    @Override
    public void fund(User user, int amount) {

        if (amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + amount + "from user " + user.toString());
            return;
        }
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "funding");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем  деньги с fromUser
        //пополняем toUser
        //1.вызываю метод
        //2.смотрю, изменился ли баланс
        if (!checkWithdraw(fromUser, amount))
            return;
        if (amount > toUser.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + amount + "from user " + toUser.toString());
            return;
        }
        if (toUser.getBank().getCurrency() == Currency.EUR && fromUser.getBank().getCurrency() != Currency.EUR || toUser.getBank().getCurrency() == Currency.USD && fromUser.getBank().getCurrency() != Currency.USD)
            return;
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "trasfer");

    }

    @Override
    public void paySalary(User user) {
        if (user.getBalance() > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + user.getBalance() + "from user " + user.toString());
            return;
        }
        user.setBalance(user.getBalance() + user.getBalance());

        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "salary");
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + "from user " + user.toString());
    }

    private Transaction createAndSaveTransaction(Date dateCreated ,TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
