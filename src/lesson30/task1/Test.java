package lesson30.task1;

import java.util.Arrays;

/**
 * Created by User on 26.03.2018.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Currency.USD);

        System.out.println(Arrays.toString(Currency.values()));

        String usd = "USD";
        Currency usdConverted = Currency.valueOf(usd);
        System.out.println(Currency.valueOf("USD"));
    }
}
