package lesson11.biginterfaceexample;

/**
 * Created by Valik on 17.03.2018.
 */
public class SimpleReader implements Readable {
    //null pointer exception - ошибка возникащая при попытке вызова переменных у null объекта
    //null - empty object

    @Override
    public void readFilesFromStorage(Storage storage) {
        for (File file : storage.getFiles()) {
            if (file != null)
                System.out.println(file.getName());
            else
                System.out.println(file);
        }
    }
}
