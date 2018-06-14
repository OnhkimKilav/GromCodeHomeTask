package lesson19.homeTask;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Valik on 05.06.2018.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Storage storage = new Storage(154, new File[5], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 500);
        Storage storage1 = new Storage(14, new File[5], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 500);
        File file = new File(1223, "fdf42", "pdf", 45);
        File file1 = new File(1225, "phd22", "pdf", 46);
        File file2 = new File(1226, "ase34", "txt", 60);
        //File file3 = new File(13453, "urooowvjjkfjaklkkf", "txt", 60);
        File file4 = new File(13222, "urooow", "txt", 60);
        File file5 = new File(13223, "urooow", "txt", 60);
        Controller controller = new Controller();
        controller.put(storage, file);
        controller.put(storage, file1);
        controller.put(storage, file2);
        controller.put(storage, file4);
        controller.put(storage, file5);
        print(storage);

        System.out.println();

//        controller.delete(storage, file4);
//        print(storage);

        System.out.println();

        controller.transferAll(storage, storage1);
        print(storage1);

        System.out.println();
        Storage storage2 = new Storage(14, new File[5], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 500);
        controller.transferFile(storage, storage2, 1225);
        print(storage2);



    }

    private static void print(Storage storage) {
        for (File file : storage.getFiles()) {
            if (file == null)
                System.out.println("null");
            else
                System.out.println(file.toString());
        }
    }
}
