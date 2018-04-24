package lesson16;

import java.util.Arrays;

/**
 * Created by Valik on 24.04.2018.
 */
public class StringCompare {
    public static void main(String[] args) {

        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));
        //выделение памяти в String Pool, ссылки на объекты будут одинаковыми, если у них одинаковые инициализации, ссылается на один и тот же кусок памяти
        System.out.println("abc" == "abc");
        System.out.println("Abc".equals("abc"));

        String s1 = "test";
        String s2 = "test";
        System.out.println(s1 == s2);

        //using intern
        //позволяет нам, наш стринг принудительно добавить в String Pool
        String s3 = new String("pppp");
        String s4 = "pppp";
        System.out.println(s2 == s4);

        s3 = s3.intern();
        System.out.println(s3 == s4);

        //bites of string
        //getBytes - возвращает массив байтов
        String str = "testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));
        System.out.println(new String(str.getBytes()));



    }
}
