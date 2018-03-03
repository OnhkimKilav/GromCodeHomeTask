package lesson5.HomeTask;

/**
 * Created by User on 05.02.2018.
 */
public class AmountUniqueNumbersByArray {
    public static void main(String[] args) {

        int[] array = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));
        //uniqueCount(array);
    }


    /*public static void uniqueCount(int[] array){
        int[] arrayWithUniqueNumbers = new int[array.length];
        int count = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                // 1 2 3 4 5 6 1 4 7 8
                // 1 2 3 4 5 6 1 4 7 8
                //
                for(int k = 0; k < arrayWithUniqueNumbers.length; k++){
                    if(i == arrayWithUniqueNumbers[k]){
                        break;
                    }
                }

                if(array[i] == array[j]){
                    functionAmountUniqueNumbers(arrayWithUniqueNumbers, i);
                    break;
                }
            }
            count++;
        }
        System.out.println(count);
    }
    static void functionAmountUniqueNumbers(int[] array, int number){
        for(int i = 0; i < array.length;i++){
            array[i] = number;
        }
    }*/

    //1. Промотать массив и найти числа, которые повторяются и закинуть их в массив
    //2. промотать массив и посчитать количество эллементов без повторяющихся
    //3. вывести на экран количество не повторяющихся элементов

   /* static int[] functionFindAmountUniqueNumbers(int[] array) {
        int[] arrayWithUniqueNumbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i + 1; j--) {
                if (array[i] == array[j]) {
                    int number = array[j];
                    arrayWithUniqueNumbers[i] = number;
                    break;
                }
            }
        }
        return arrayWithUniqueNumbers;
    }*/


    //Юзабельный код


    static int uniqueCount(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {              //11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11
            for (int j = array.length - 1; j >= i; j--) {
                if (i == j)
                    count++;                                    //11, 0, 10, 0, 0, 44, 0, 44, 11, 10, 0
                if (array[i] == array[j]) {                             //первому элементу присвоить номер, сравнить его со всем
                    break;
                }
            }

        }
        return count;
    }

}
