package lesson35.user;

import java.io.*;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserDAO {
    private static File fileUser = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\UserDb.txt");
    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user) throws Exception {
        //save user to db(file)
        validateFileWrite();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUser, true))) {
            writer.write(String.valueOf(user.getId()));
            writer.append(", ").append(user.getUserName()).append(", ").append(user.getPassword()).append(", ").append(user.getCountry()).append(", ").write(String.valueOf(user.getType()));
            writer.append("\n");
        } catch (IOException e) {
            System.err.println("User " + user.getId() + " can't write to file");
        }

        return user;
    }

    public StringBuffer logIn() throws Exception {
        validateFileRead();

        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileUser))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + fileUser.toPath() + " failed");
        }

        return res;
    }

    private static void validateFileRead() throws Exception {
        if (!fileUser.exists())
            throw new FileNotFoundException("File " + fileUser + " does not exist");
        if (!fileUser.canRead())
            throw new Exception("File " + fileUser + " does not have permissions to be read");
    }

    private static void validateFileWrite() throws Exception {
        if (!fileUser.exists())
            throw new FileNotFoundException("File " + fileUser + " does not exist");
        if (!fileUser.canWrite())
            throw new Exception("File " + fileUser + " does not have permissions to be written");
    }

}
