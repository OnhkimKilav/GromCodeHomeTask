package lesson17.homeTask;

import java.util.Arrays;

/**
 * Created by Valik on 23.05.2018.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbersWithTry("12 QASZ 564 lk 111")));
        System.out.println(Arrays.toString(findNumbers("12 QASZ 564 lk 111")));
    }

    public static int[] findNumbersWithTry(String text) {
        String[] arrayWordsWithoutSpace = text.split(" ");
        int lengthArray = 0;
        int stepEntryIntoArray = 0;
        int stringInInt = 0;

        int[] arrayResult = new int[identifyTheLengthOfArray(arrayWordsWithoutSpace, lengthArray)];

        for (String word : arrayWordsWithoutSpace) {
            try {
                stringInInt = Integer.parseInt(word);
            } catch (Exception e) {
                System.out.println("not a number");
                continue;
            }

            arrayResult[stepEntryIntoArray] = stringInInt;
            stepEntryIntoArray++;
        }
        return arrayResult;
    }

    public static int[] findNumbers(String text){
        String[] arrayWordsWithoutSpace = text.split(" ");
        int lengthArray = 0;
        int stepEntryIntoArray = 0;
        int stringInInt = 0;
        boolean step = false;

        int[] arrayResult = new int[identifyTheLengthOfArray(arrayWordsWithoutSpace, lengthArray)];

        for (String word : arrayWordsWithoutSpace) {
            char[] arrayLetters = word.toCharArray();
            for (Character letter : arrayLetters) {
                if (Character.isDigit(letter)) {
                    step = true;
                } else {
                    step = false;
                    break;
                }
            }

            if (step)
                stringInInt = Integer.parseInt(word);
            else {
                System.out.println("not a number");
                continue;
            }

            try {
                stringInInt = Integer.parseInt(word);
            } catch (Exception e) {
                System.out.println("not a number");
                continue;
            }

            //записать в массив
            arrayResult[stepEntryIntoArray] = stringInInt;
            stepEntryIntoArray++;
        }
        return arrayResult;
    }

    private static int identifyTheLengthOfArray(String[] arrayWordsWithoutSpace, int lengthArray) {
        for (String word : arrayWordsWithoutSpace) {
            char[] arrayLetters = word.toCharArray();
            boolean step = false;

            for (Character letter : arrayLetters) {
                if (Character.isDigit(letter)) {
                    step = true;
                } else {
                    step = false;
                    break;
                }
            }
            if (step)
                lengthArray++;
        }
        return lengthArray;
    }
}

