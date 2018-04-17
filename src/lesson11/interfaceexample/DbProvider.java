package lesson11.interfaceexample;

/**
 * Created by Valik on 12.03.2018.
 */
public interface DbProvider {

    void connectToDb();

    void disconnectFromDb();

    void encryptData();

}
