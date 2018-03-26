package lesson12;

/**
 * Created by User on 26.03.2018.
 */
public interface BankSystem {
    void withdraw(User user, int amount);

    void fund(User uesr, int amount);

    void transferMoney(User fromUser, User toUser, int amount);

    void paySalary(User user);
}
