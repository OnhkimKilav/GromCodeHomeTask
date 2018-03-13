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

    private String[] canShippingFromAndToCity = {"Киев", "Одесса", "Днепр", "Харьков"};



    @Override
    void validateOrder() {
        for (String city : canShippingFromAndToCity) {
            if (getShipFromCity() == city && getShipToCity() == city && getBasePrice() > 100) {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    void calculatePrice() {
        double sumForDelivery = 0;
        for(String city : canShippingFromAndToCity){
            if(city == "Киев" || city == "Одесса"){
                sumForDelivery = getBasePrice() - (getBasePrice() * 0.15);
            }
            sumForDelivery = getBasePrice() - (getBasePrice() * 0.1);
        }
        if(getBasePrice()>1000)
            sumForDelivery -= sumForDelivery * 0.05;

        setTotalPrice(sumForDelivery);
    }
}
