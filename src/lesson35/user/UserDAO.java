package lesson35.user;

import lesson35.Validate;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserDAO {
    private static File fileUserDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\UserDb.txt");
    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user) throws Exception {
        //save user to db(file)
        Validate.validateFileWrite(fileUserDb);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUserDb, true))) {
            writer.write(String.valueOf(user.getId()));
            writer.append(", ").append(user.getUserName()).append(", ").append(user.getPassword()).append(", ").append(user.getCountry()).append(", ").write(String.valueOf(user.getType()));
            writer.append("\n");
        } catch (IOException e) {
            System.err.println("User " + user.getId() + " can't write to file");
        }

        return user;
    }

    public StringBuffer logIn() throws Exception {
        Validate.validateFileRead(fileUserDb);

        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileUserDb))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + fileUserDb.toPath() + " failed");
        }

        return res;
    }

}
