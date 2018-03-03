package lesson7.HomeTask;

import lesson6.HomeTask.Order;

import java.util.Date;

/**
 * Created by Valik on 11.02.2018.
 */
public class DemoHomeWork {
    public static void main(String[] args) {

    }

    public Order createOrder(){
        Order order = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return order;
    }



    public Order createOrderAndCallMethods(){
        Order order = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        order.confirmOrder();
        order.checkPrice();
        order.isValidType();
        return order;
    }


}
