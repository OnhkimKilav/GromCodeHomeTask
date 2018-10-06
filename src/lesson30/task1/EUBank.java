package lesson30.task1;

/**
 * Created by User on 26.03.2018.
 */
public class EUBank extends Bank {

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 2000;
        else
            return 2200;
    }

    @Override
    int getLimitOfFunding() {
        if (getCurrency() == Currency.EUR)
            return 20000;
        else return 10000;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.USD)
            return 0.0;
        else return 0.01;
    }

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.05;
            else return 0.07;
        } else {
            if (amount <= 1000)
                return 0.02;
            else return 0.04;
        }
    }
}
