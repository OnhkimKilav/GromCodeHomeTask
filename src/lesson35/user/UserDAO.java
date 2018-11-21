package lesson35.user;

import lesson35.Content;
import lesson35.Validate;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserDAO {
    private static File fileUserDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\UserDb.txt");
    private byte valueWriteFile = 0;
    private byte valueReadFile = 0;
    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user) throws Exception {
        //save user to db(file)
        valueWriteFile = Validate.validateValueWriteFile(valueWriteFile, fileUserDb);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUserDb, true))) {
            writer.write(String.valueOf(user.getId()) + ", " + user.getUserName() + ", " + user.getPassword() + ", " + user.getCountry() + ", " + user.getType() + "\n");
        } catch (IOException e) {
            System.err.println("User " + user.getId() + " can't write to file");
        }

        return user;
    }

    public StringBuffer logIn() throws Exception {
        valueReadFile = Validate.validateValueReadFile(valueReadFile, fileUserDb);

        return Content.readFile(fileUserDb);
    }
}
