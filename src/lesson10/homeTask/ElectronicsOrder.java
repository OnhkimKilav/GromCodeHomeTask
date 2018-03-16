package lesson10.homeTask;

import java.util.Date;

/**
 * Created by Valik on 12.03.2018.
 */
public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
    }

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    private String[] canShippingFromAndToCity = {"Киев", "Одесса", "Днепр", "Харьков"};


    @Override
    public void validateOrder() {
        for (String city : canShippingFromAndToCity) {
            if (getShipFromCity() == city && getShipToCity() == city && getBasePrice() > 100) {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    public void calculatePrice() {
        double sumForDelivery = 0;

        for (String city : canShippingFromAndToCity) {
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса") {
                sumForDelivery = getBasePrice() + (getBasePrice() * 0.1);
            } else
                sumForDelivery = getBasePrice() + (getBasePrice() * 0.15);
        }

        if (getBasePrice() > 1000)
            sumForDelivery -= sumForDelivery * 0.05;

        setTotalPrice(sumForDelivery);
    }
}
