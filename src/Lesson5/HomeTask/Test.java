package Lesson5.HomeTask;

import java.util.Arrays;

/**
 * Created by User on 03.02.2018.
 */
public class Test {

    public static void main(String[] args) {
        String[] name = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balance = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(withdraw(name, balance, "Nikolay", 100));
    }
    static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }
    public static int withdraw(String[] clients, int[] balances, String client, int amount) {
        //findRemnantByBalanceAfterWithdraw(balances,amount,findClientIndexByName(clients, client));
        if(balances[findClientIndexByName(clients,client)] >= amount)
            return balances[findClientIndexByName(clients, client)] -= amount;
        else
            return -1;
    }
}