package Lesson2.HomeTasks;

/**
 * Created by Valik on 27.01.2018.
 */
public class SumAndDivision {
    public static void main(String[] args) {

        int sum = 0;
        int a = 1;
        while (a<= 1000){
            sum += a;
            a++;
        }

        int divInteger = sum/1234;
        int divBalance = sum%1234;
        boolean ans;

        while(divBalance>divInteger) {
            ans = true;
            System.out.println(ans);
            break;
        }
        while(divBalance<divInteger) {
            ans = false;
            System.out.println(ans);
            break;
        }

    }
}
