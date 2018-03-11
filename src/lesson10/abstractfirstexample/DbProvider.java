package lesson10.abstractfirstexample;

/**
 * Created by Valik on 12.03.2018.
 */
public abstract class DbProvider {
    private String dbHost;

    abstract void connectToDb();

    abstract void disconnectFromDb();

    void printDbHost() {
        System.out.println("DB host is " + dbHost);
    }
}
