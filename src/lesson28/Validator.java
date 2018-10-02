package lesson28;

/**
 * Created by Valik on 02.10.2018.
 */
public class Validator <T, K, V>{

    public void validator(T t, K k, V v) throws NullPointerException{
        if(t.equals(null))
            throw new NullPointerException(t + " can't be null");
        else if(k.equals(null))
            throw new NullPointerException(k + " can't be null");
        else if(v.equals(null))
            throw new NullPointerException(v + " can't be null");
    }
}
