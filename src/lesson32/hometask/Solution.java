package lesson32.hometask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Valik on 19.10.2018.
 */
public class Solution {
    private static int countWrong = 3;

    public static void readNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (countWrong >= 0) {
            boolean point = true;
            String str = reader.readLine();
            String[] strings = str.split(" ");
            validateLength(strings.length);

            for (String string : strings) {
                if(!validateStr(string)){
                    point = false;
                    break;
                }
                int iStr = Integer.parseInt(string);
                if (!validateInt(iStr)) {
                    point = false;
                    break;
                }
                sum += iStr;
            }
            if (point || countWrong == 0)
                break;
        }
        if (countWrong == 0) {
            System.out.println("Your numbers are wrong. Number of attempts exceeded");
            return;
        }

        System.out.println(sum);
    }

    private static boolean validateLength(int size){
        if(!(size == 10)){
            if (countWrong == 1) {
                countWrong--;
                return false;
            }
            countWrong--;
            System.out.println("You numbers are wrong. You have " + countWrong + " attempts to try again");
            return false;
        }
        return true;
    }

    private static boolean validateStr(String str){
        if(!str.matches("[\\d]+")){
            if (countWrong == 1) {
                countWrong--;
                return false;
            }
            countWrong--;
            System.out.println("You numbers are wrong. You have " + countWrong + " attempts to try again");
            return false;
        }
        return true;
    }

    private static boolean validateInt(int iStr) throws IOException {
        if (iStr > 100) {
            if (countWrong == 1) {
                countWrong--;
                return false;
            }
            countWrong--;
            System.out.println("You numbers are wrong. You have " + countWrong + " attempts to try again");
            return false;
        }
        return true;
    }
}
