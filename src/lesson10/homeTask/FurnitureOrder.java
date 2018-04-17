package lesson10.homeTask;

import java.util.Date;

import static java.lang.Character.getName;

/**
 * Created by User on 13.03.2018.
 */
public class FurnitureOrder extends Order {

    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
    }

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if ((getShipFromCity() == "Киев" || getShipFromCity() == "Львов") && getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест") {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        double sumForDelivery = 0;

        if (getBasePrice() < 5000)
            sumForDelivery = getBasePrice() + (getBasePrice() * 0.05);
        else
            sumForDelivery = getBasePrice() + (getBasePrice() * 0.02);

        setTotalPrice(sumForDelivery);
    }
}
