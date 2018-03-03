package lesson8.phones;

/**
 * Created by Valik on 15.02.2018.
 */
public class Demo {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone(110,10.0,"China", true);
        iPhone.DeleteIPhoneFromDb();
        iPhone.orderPhone();
    }
}
