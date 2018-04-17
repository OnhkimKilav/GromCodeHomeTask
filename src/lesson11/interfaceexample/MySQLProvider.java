package lesson11.interfaceexample;

/**
 * Created by Valik on 12.03.2018.
 */
public class MySQLProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic for MySQL
    }

    @Override
    public void disconnectFromDb() {
        //some logic for MySQL
    }

    @Override
    public void encryptData() {
        //some logic for MySQL
    }
}
