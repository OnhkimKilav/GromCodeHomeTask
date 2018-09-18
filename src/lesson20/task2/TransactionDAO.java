package lesson20.task2;

import lesson20.task1.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Valik on 18.09.2018.
 */
public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        //сумма транзакций больше указанного лимита +
        //сумма транзакций за день больше дневного лимита +
        //количество транзакций за день большего указанного лимита +
        //если город оплаты (совершения транзакции) не разрешен +
        //не хватило места +

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                break;
            }
            index++;
        }

        return transaction;
    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        int count = 0;
        int sum = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCtreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");

        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");

        String str = null;
        for (String city : utils.getCities()) {
            if (transaction.getCity() == city)
                str = city;
        }

        if (str == null)
            throw new BadRequestException("Transaction " + transaction.getId() + " not be allowed with city " + transaction.getCity() + ". Can't be saved");

        int countTr = 0;
        for (Transaction tr : transactions)
            if (tr != null)
                countTr++;

        if (countTr > transactions.length)
            throw new InternalServerException("Count transactions is max. Transaction " + transaction.getId() + " can't be saved");
    }

    Transaction[] transactionList() {
        return transactions;

    }

    Transaction[] transactionList(String city) throws InternalServerException {
        int countTrInCity = 0;
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getCity().equals(city))
                countTrInCity++;
        }
        Transaction[] transactions = new Transaction[countTrInCity];
        for (Transaction transaction : transactions) {
            if (transaction.getCity().equals(city))
                transactions[index] = transaction;
        }
        if(countTrInCity == 0)
            throw new InternalServerException("Transactions don't contain city " + city + ".");

        return transactions;
    }

    Transaction[] transactionList(int amount) throws InternalServerException {

        int countTrByAmount = 0;
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() == amount)
                countTrByAmount++;
        }

        if(countTrByAmount == 0)
            throw new InternalServerException("Transactions don't contain amount " + amount + ".");

        Transaction[] transactions = new Transaction[countTrByAmount];
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() == amount)
                transactions[index] = transaction;
        }
        return transactions;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCtreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCtreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }
}
