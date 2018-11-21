package lesson35.order;

import lesson35.Content;
import lesson35.Validate;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderDAO {
    private static File fileOrder = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\Order.txt");
    private byte valueWriteFile = 0;
    private byte valueReadFile = 0;

    public void writeOrder(Order order) throws Exception {
        valueWriteFile = Validate.validateValueWriteReadFile(valueWriteFile, fileOrder);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOrder, true))) {
            writer.write(String.valueOf(order.getId()) + ", " + order.getUser() + ", " + order.getRoom() + ", " + Content.dateToStr(order.getDateFrom()) + ", " + Content.dateToStr(order.getDateTo()) + ", " + order.getMoneyPaid() + "\n");
        } catch (IOException e) {
            System.err.println("Order " + order.getId() + " can't write to file");
        }

    }

    public StringBuffer readOrder() throws Exception {
        valueReadFile = Validate.validateValueWriteReadFile(valueReadFile, fileOrder);

        return Content.readFile(fileOrder);
    }

    public void cleaningFile() throws Exception {
        valueWriteFile = Validate.validateValueWriteReadFile(valueWriteFile, fileOrder);

        Content.cleaningFile(fileOrder);
    }
}
