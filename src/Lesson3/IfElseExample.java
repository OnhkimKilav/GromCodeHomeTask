package Lesson3;

/**
 * Created by Valik on 29.01.2018.
 */
public class IfElseExample {
    public static void main(String[] args) {
        int test = 1000;

        if(test > 100){
            System.out.println("Good");
        }else{
            System.out.println("Bad");
        }

        //if(condition) {
        // if-body
        // }
        //else{
        // else-body
        // }

        int test1 = 1000;
        boolean result = false;

        if(test1 > 1000)
            result = true;

        if(result)
            System.out.println("Nice");
        else
            System.out.println("Not nice");

        //if(condition - logical operator - condition2 ....) {
        // if-body
        // }
        //else{
        // else-body
        // }

        if(result && test > 100 || test > 500)
            System.out.println("!");
        else
            System.out.println("?");

        if(!(test1 > 0)){
            System.out.println("!!!!!!");
        }

    }
}
