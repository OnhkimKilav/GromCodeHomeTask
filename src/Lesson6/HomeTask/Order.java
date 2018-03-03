package Lesson6.HomeTask;

import java.util.Date;

/**
 * Created by Valik on 09.02.2018.
 */
public class Order {
    public static void main(String[] args) {

    }

    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;

    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public Order() {
    }

    public void confirmOrder() {
        if (!isConfirmed) {
            isConfirmed = true;
            dateConfirmed = new Date();
        }
    }

    public boolean checkPrice() {
        return price > 1000 ? true : false;
    }

    public boolean isValidType() {
        if (type == "Buy" && type == "Sale")
            return true;
        else
            return false;
    }
}
