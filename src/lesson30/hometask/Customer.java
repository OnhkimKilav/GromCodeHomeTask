package lesson30.hometask;

/**
 * Created by Valik on 07.10.2018.
 */
public class Customer {
    private String name;
    private String country;
    private int monthlyPay;

    public Customer(String name, String country, int monthlyPay) {
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }
}
