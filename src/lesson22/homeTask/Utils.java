package lesson22.homeTask;

/**
 * Created by Valik on 18.09.2018.
 */
public class Utils {
    private static int limitTransactionsPerDayCount = 10;
    private static int limitTransactionsPerDayAmount = 100;
    private static int limitSimpleTransactionAmount = 40;
    private static String[] cities = {"Kiev", "Odessa"};

    public static int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public static int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public static int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public static String[] getCities() {
        return cities;
    }
}
