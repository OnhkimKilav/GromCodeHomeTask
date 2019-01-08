package lesson35.DAO;

import lesson35.util.Validate;
import lesson35.model.Order;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderDAO extends GeneralDAO{
    private static File fileOrder = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\Order.txt");

    @Override
    public Order transformationStringToUser(String[] values) {
        return null;
    }

    public OrderDAO() throws Exception {
        Validate.validateFileRead(fileOrder);
        Validate.validateFileWrite(fileOrder);
    }

    public void writeOrder(Order order) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOrder, true))) {
            writer.write(String.valueOf(order.getId()) + ", " + order.getUser() + ", " + order.getRoom() + ", " + GeneralDAO.dateToStr(order.getDateFrom()) + ", " + GeneralDAO.dateToStr(order.getDateTo()) + ", " + order.getMoneyPaid() + "\n");
        } catch (IOException e) {
            throw new IOException("Order " + order.getId() + " can't write to file");
        }

    }

    public StringBuffer readOrder() throws Exception {
        return GeneralDAO.readFile(fileOrder);
    }

    public void cleaningFile() throws Exception {
        GeneralDAO.cleaningFile(fileOrder);
    }
}
