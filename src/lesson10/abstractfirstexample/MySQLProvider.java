package lesson10.abstractfirstexample;

/**
 * Created by Valik on 12.03.2018.
 */
public class MySQLProvider extends DbProvider {

    @Override
    void connectToDb() {
        //logic for MySQL
    }

    @Override
    void disconnectFromDb() {

    }
}
