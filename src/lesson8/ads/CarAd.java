package lesson8.ads;

/**
 * Created by Valik on 17.02.2018.
 */
public class CarAd extends Ad{
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    public CarAd(long id, int price) {
        super(id, price);
    }

    void confirmAd(){
        //some logic
    }
}
