package lesson20.task2;

import java.util.Date;

/**
 * Created by Valik on 18.09.2018.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        Transaction transaction = new Transaction(123, "Kiev", 1, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction1 = new Transaction(124, "Kiev", 1, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(125, "Kiev", 1, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(126, "Odessa", 5, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(127, "Kiev", 1, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(128, "Kiev", 5, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(129, "Kiev", 1, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(130, "Kiev", 6, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(131, "Kiev", 40, "dfsdf", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(132, "Kiev", 40, "dfsdf", TransactionType.INCOME, new Date());
        //Transaction transaction10 = new Transaction(133, "Kiev", 5, "dfsdf", TransactionType.INCOME, new Date());

        controller.save(transaction);
        controller.save(transaction1);
        controller.save(transaction2);
        controller.save(transaction3);
        controller.save(transaction4);
        controller.save(transaction5);
        controller.save(transaction6);
        controller.save(transaction7);
        controller.save(transaction8);
        controller.save(transaction9);
        //controller.save(transaction10);

        System.out.println();
        for(Transaction transactions : controller.transactionList())
            System.out.println(transactions);

        System.out.println();
        for(Transaction transactions1 : controller.transactionList(5))
            System.out.println(transactions1);

        System.out.println();
        for(Transaction transactions1 : controller.transactionList("Odessa"))
            System.out.println(transactions1);

    }
}
