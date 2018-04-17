package lesson11.firstinterface;

/**
 * Created by Valik on 16.03.2018.
 */
public interface FirstInterface {
    //область видисости - access modifier
    //в интерфейсах все методы по умолчанию public
    //private или protected не могут быть в принципе
    //интерфейс это конструкция которая содержит только абстрактные методы

    void send();

    String receive();

}
