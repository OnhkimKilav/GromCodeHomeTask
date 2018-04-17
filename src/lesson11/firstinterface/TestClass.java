package lesson11.firstinterface;

/**
 * Created by Valik on 17.03.2018.
 */
public class TestClass implements FirstInterface{

    private int test = 10;

    @Override
    public void send() {
        //some logic
    }

    @Override
    public String receive() {
        //some logic
        return null;
    }
}
