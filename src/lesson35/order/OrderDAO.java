package lesson35.order;

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

    public StringBuffer readOrder() throws Exception {
        if (valueReadFile == 0) {
            Validate.validateFileRead(fileOrder);
            valueReadFile++;
        }

        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileOrder))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + fileOrder.toPath() + " failed");
        }

        return res;
    }

    public void cleaningFile() throws Exception {
        if (valueWriteFile == 0) {
            Validate.validateFileWrite(fileOrder);
            valueWriteFile++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOrder))) {
            writer.append("");
        } catch (IOException e) {
            System.err.println("FileOrder " + fileOrder.toPath() + " can't cleaning");
        }
    }
}
