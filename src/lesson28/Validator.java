package lesson28;

/**
 * Created by Valik on 03.10.2018.
 */
public class Validator<T, K> {
    public int validator(T t, K k){

        try {
            if (t.equals(null));
        }catch (NullPointerException e) {
            return 1;
        }
        try {
            if (k.equals(null));
        }catch (NullPointerException e) {
            return -1;
        }
        return 0;
    }
}
