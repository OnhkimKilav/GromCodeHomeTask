package lesson16;

import java.util.Arrays;

/**
 * Created by Valik on 24.04.2018.
 */
public class StringMethods {
    public static void main(String[] args) {

        String test = "someStringExample";

        //isEmpty - проверят пустой ли String и возвращает boolean
        System.out.println(test.isEmpty());
        System.out.println("".isEmpty());
        //length - выводит длину String-а
        System.out.println(test.length());
        //charAt - находит конкретный char, который находится на конкретной позиции
        System.out.println(test.charAt(2));
        //replace - заменяет первый элемент char или String на второй элемент char или String
        String res = test.replace("me", "T");
        System.out.println(res);
        //replaceAll - такой же как и replace, только умеет работать с regex-ами
        System.out.println(test.replaceAll("me", "T"));
        //contains - проверяет содержит ли String заданный char или String
        System.out.println(test);
        System.out.println(test.contains("mes"));
        //split - возвращает нам массив String-ов, делит наш String на массив под-String-ов, но удаляет то, по чему мы делаем деление(элемент)
        System.out.println(test);
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));
        //trim - удаляет пробелы в конце или в начале нашего String-а
        System.out.println(" test a".trim());
        //substring - возвращает нам String, который является под-String-ом нашего изначального String-а
        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(5, 10).trim());
        //toUpperCase - все буквы в String-е приводятся к большим
        System.out.println(test.toUpperCase());
        //toLowerCase - все буквы в String-е приводятся к маленьким
        System.out.println(test.toLowerCase());


        test.getBytes();
        test.equals("eeee");
        test.intern();


    }
}
