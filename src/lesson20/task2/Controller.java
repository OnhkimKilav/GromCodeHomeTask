package lesson20.task2;

import lesson20.task1.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

/**
 * Created by Valik on 18.09.2018.
 */
public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList() throws InternalServerException {
        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) throws BadRequestException {
        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) throws InternalServerException {
        return transactionDAO.transactionList(amount);
    }
}
