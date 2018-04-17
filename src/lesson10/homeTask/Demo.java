package lesson10.homeTask;

import java.util.Date;

/**
 * Created by User on 13.03.2018.
 */
public class Demo {
    public static void main(String[] args) {
        //test ElectronicsOrder method validateOrder
        //создание заказа
        //создание заказа с пустыми городами
        //создание заказа с меньшей величиной минимальной цены заказа

        Customer customer = new Customer("Ann", "Одесса", "female");
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("PC", new Date(), "Киев", "Одесса", 500, customer);

        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());

    }
}
