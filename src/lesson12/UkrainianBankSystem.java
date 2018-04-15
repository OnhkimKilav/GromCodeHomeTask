package lesson12;

/**
 * Created by User on 26.03.2018.
 */
public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {
        //проверить можно ли снять - проверить лимит, проверить достаточно ли денег
        //снять деньги

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {

        if (amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + amount + "from user " + user.toString());
            return;
        }
        user.setBalance(user.getBalance() + amount);
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
    }

    @Override
    public void paySalary(User user) {
        fund(user, (int)user.getBank().getAvrSalaryOfEmployee());
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
}
