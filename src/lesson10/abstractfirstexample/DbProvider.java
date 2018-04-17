package lesson10.abstractfirstexample;

/**
 * Created by Valik on 12.03.2018.
 */
public abstract class DbProvider {

    //абстрактные классы могут содержать в себе абстрактные методы и методы с реализацией

    private String dbHost;

    abstract void connectToDb();

    abstract void disconnectFromDb();

    void printDbHost() {
        System.out.println("DB host is " + dbHost);
    }
}
