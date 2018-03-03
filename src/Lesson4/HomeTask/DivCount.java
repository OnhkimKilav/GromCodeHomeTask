package Lesson4.HomeTask;

/**
 * Created by User on 01.02.2018.
 */
public class DivCount {

    public static void main(String[] args) {
        System.out.println(findDivCount((short)1, (short)10, 2));
    }
    


    public static int findDivCount(short a, short b, int n) {

        //if(number%n == 0)
        int count = 0;
        for (int i = a; i <= b; i++) {
            if ((i % n) == 0)
                count++;
        }

        return count;
    }
}
