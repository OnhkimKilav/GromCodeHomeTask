package lesson22.homeTask;

/**
 * Created by Valik on 18.09.2018.
 */
public class Controller {

    public Transaction save(Transaction transaction) throws Exception {
        return TransactionDAO.save(transaction);
    }

    Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) {
        return TransactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) {
        return TransactionDAO.transactionList(amount);
    }
}
