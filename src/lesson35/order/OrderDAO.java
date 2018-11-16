package lesson35.order;

import lesson35.Validate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Valik on 05.11.2018.
 */
public class OrderDAO {
    private static File fileOrder = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\Order.txt");
    private byte valueWriteFile = 0;

    public void bookRoom(Order order) throws Exception {
        if (valueWriteFile == 0) {
            Validate.validateFileWrite(fileOrder);
            valueWriteFile++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOrder, true))) {
            writer.write(String.valueOf(order.getId()) + ", " + order.getUser() + ", " + order.getRoom() + ", " + order.getDateFrom() + ", " + order.getDateTo() + ", " + order.getMoneyPaid() + "\n");
        } catch (IOException e) {
            System.err.println("Order " + order.getId() + " can't write to file");
        }

    }
}
