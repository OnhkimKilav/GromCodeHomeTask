package lesson25;

/**
 * Created by Valik on 24.09.2018.
 */
public class Order extends IdEntity {

    private long id;

    public Order(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
