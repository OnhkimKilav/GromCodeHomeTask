package lesson10.polyexample;

/**
 * Created by Valik on 11.03.2018.
 */
public class Child extends Human {

    public Child(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("child class is called...");
        super.run();
    }
}
