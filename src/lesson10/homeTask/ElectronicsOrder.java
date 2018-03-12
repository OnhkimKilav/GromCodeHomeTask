package lesson10.homeTask;

/**
 * Created by Valik on 12.03.2018.
 */
public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    private String[] canShippingFromAndToCity = {"Киев", "Одесса", "Днепр", "Харьков"};

    @Override
    void validateOrder() {
        for (String city : canShippingFromAndToCity) {
            if (getShipFromCity() == city && getShipToCity() == city) {
                getShipFromCity();
                getShipToCity();
            }
        }
        if(getBasePrice() > 100)
            getBasePrice();


    }
}
