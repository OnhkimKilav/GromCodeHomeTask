package lesson35.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserDAO {
    private File fileUser = new File("D:\\Programs\\YandexDisk\\Программач Java\\какие то файлы\\UserDb.txt");
    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user){
        //save user to db(file)
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileUser, true))){
            writer.write(String.valueOf(user.getId()));
            writer.append(", ").append(user.getUserName()).append(", ").append(user.getPassword()).append(", ").append(user.getCountry()).append(", ").write(String.valueOf(user.getType()));
            writer.append("\n");
        }catch (IOException e){
            System.err.println("User " + user.getId() + " can't write to file");
        }

        return user;
    }
}
