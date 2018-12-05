package lesson35.DAO;

import lesson35.model.UserType;
import lesson35.util.Validate;
import lesson35.model.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserDAO extends GeneralDAO {
    private static File fileUserDb = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\UserDb.txt");
    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    @Override
    public User transformationStringToUser(String[] valuesUser) {
        return new User(Long.parseLong(valuesUser[0]), valuesUser[1], valuesUser[2], valuesUser[3], UserType.valueOf(valuesUser[4]));
    }

    static {
        try {
            Validate.validateFileWrite(fileUserDb);
            Validate.validateFileRead(fileUserDb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User registerUser(User user) throws Exception {
        //save user to db(file)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUserDb, true))) {
            writer.write(user.toString());
        } catch (IOException e) {
            throw new IOException("User " + user.getId() + " can't write to file");
        }

        return user;
    }

    public ArrayList<User> listUser() throws Exception {
        ArrayList<User> res = new ArrayList<>();
        String userContent = GeneralDAO.readFile(fileUserDb).toString();
        String[] fileUsers = userContent.split("\n");

        for (String fileUser : fileUsers) {
            String[] valuesUser = fileUser.split(", ");
            res.add(transformationStringToUser(valuesUser));
        }

        return res;
    }
}
