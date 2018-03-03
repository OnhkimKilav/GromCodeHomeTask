package Lesson8.phones;

/**
 * Created by Valik on 15.02.2018.
 */
public class IPhone extends Phone {
    int price;
    double weight;
    String countryProduced;

    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
        super(price, weight, countryProduced);
        System.out.println("Phone constructor was invoked...");
        this.fingerPrint = fingerPrint;
    }

    void DeleteIPhoneFromDb(){
        System.out.println("DeleteIPhoneFromDb invoked...");
    }
}
