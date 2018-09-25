package lesson25;

/**
 * Created by Valik on 24.09.2018.
 */
public class TestClass <T, V, K> {

    public T doSomething1(T t){
        System.out.println("1");
        //logic
        return t;
    }

    public K doSomething2(K k){
        System.out.println("2");
        //logic
        return k;
    }

    public V doSomething3(V v){
        System.out.println("3");
        //logic
        return v;
    }
}
