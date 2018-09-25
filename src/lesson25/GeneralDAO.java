package lesson25;

/**
 * Created by Valik on 24.09.2018.
 */
public class GeneralDAO {
    private void print(Order order){
        System.out.println("order is: " + order.toString());

    }

    public <T extends IdEntity> void validate(T t) throws Exception{
        if(t.getId() <= 0)
            throw new Exception("id can't be negative");

    }

    public <K> void validate(K k){
        if(k.equals(100))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
