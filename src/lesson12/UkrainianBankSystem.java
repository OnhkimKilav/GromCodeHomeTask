package lesson12;

/**
 * Created by User on 26.03.2018.
 */
public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {
        //проверить можно ли снять - проверить лимит, проверить достаточно ли денег
        //снять деньги

        /*int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();

        if (amount + user.getBank().getCommission(amount) < limitOfWithdrawal) {
            printWithdrawalErrorMsg(amount, user);
            return;
        }

        if (amount + user.getBank().getCommission(amount) < user.getBalance()) {
            printWithdrawalErrorMsg(amount, user);
            return;
        }*/

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {

        if (amount < user.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + amount + "from user " + user.toString());
            return;
        }

        if (user.getBalance() + amount > Integer.MAX_VALUE) {
            System.err.println("Can't fund money " + amount + "from user " + user.toString());
            return;
        }
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем  деньги с fromUser
        //пополняем toUser

        withdraw(fromUser, amount);

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

        toUser.setBalance(toUser.getBalance() + amount - amount * toUser.getBank().getCommission(amount));
    }

    @Override
    public void paySalary(User user) {
        fund(user, (int) user.getBank().getAvrSalaryOfEmployee());
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
