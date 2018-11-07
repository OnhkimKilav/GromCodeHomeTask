package lesson35.hotel;

import lesson35.Validate;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class HotelDAO {
    private static File fileHotelDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\HotelDb.txt");

    public StringBuffer findHotelByName() throws Exception {
        Validate.validateFileRead(fileHotelDb);

        return findHotel();
    }

    public StringBuffer findHotelByCity() throws Exception {
        Validate.validateFileRead(fileHotelDb);

        return findHotel();
    }

    private StringBuffer findHotel(){
        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileHotelDb))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + fileHotelDb.toPath() + " failed");
        }

        return res;
    }
}
