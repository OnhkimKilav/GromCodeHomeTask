package lesson5;

import java.util.Arrays;

/**
 * Created by User on 03.02.2018.
 */
public class BanksPractice {

    public static void main(String[] args) {
        String[] name = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balance = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(findClientsByBalance(name, balance, -100)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(name, balance)));
        depositMoney(name, balance, "Ann", 2000);
        System.out.println(Arrays.toString(balance));
        System.out.println(withdraw(name, balance, "John", 100));
    }

    public static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        //String[] results = new String[clients.length];

        //1. Находим кол-во результатов
        //2. Создаем массив с длинной результатов
        //3. Записываем результат

        //1
        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }

        //2
        String[] results = new String[count];

        //3
        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }


    public static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        //String[] results = new String[clients.length];

        //1. Находим кол-во результатов
        //2. Создаем массив с длинной результатов
        //3. Записываем результат

        //1
        int count = 0;
        for (int balance : balances) {
            if (balance < 0)
                count++;
        }

        //2
        String[] results = new String[count];

        //3
        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    public static void depositMoney(String[] clients, int[] balances, String client, int money) {
        //1. найти клиента в базе(в нашем сучае в массиве)
        //2. считаем сумму пополнения с учетом комисси
        //3. обновляем баланс (пополняем)

        //int clientIndex = findClientIndexByName(clients, client);


        //int moneyToDeposit = calculateDepositAmountAfterCommission(money);

        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterCommission(money);
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

    static int calculateDepositAmountAfterCommission(int money) {
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
    }

    public static int withdraw(String[] clients, int[] balances, String client, int amount) {
        //findRemnantByBalanceAfterWithdraw(balances,amount,findClientIndexByName(clients, client));
        if(balances[findClientIndexByName(clients,client)] >= amount)
            return balances[findClientIndexByName(clients, client)] -= amount;
        else
            return -1;
    }
    /*static int findRemnantByBalanceAfterWithdraw(int[] balances,int amount){
        return balances[findClientIndexByName()] -= amount;
    }*/
}
