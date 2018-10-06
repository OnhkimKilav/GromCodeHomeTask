package lesson30.task1;

/**
 * Created by User on 26.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4 , 444343434);
        User user = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);

        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user, 150);

        System.out.println(user.getBalance());

        bankSystem.fund(user, 2000);
        System.out.println(user.getBalance());

    }
}
