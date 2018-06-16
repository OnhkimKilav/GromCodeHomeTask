package lesson19.homeTask;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Valik on 05.06.2018.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
//        Storage storage = new Storage(154, new File[5], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 500);
//        Storage storage1 = new Storage(14, new File[5], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 500);
//        File file = new File(1223, "fdf42", "pdf", 45);
//        File file1 = new File(1225, "phd22", "pdf", 46);
//        File file2 = new File(1226, "ase34", "txt", 60);
//        //File file3 = new File(13453, "urooowvjjkfjaklkkf", "txt", 60);
//        File file4 = new File(13222, "urooow", "txt", 60);
//        File file5 = new File(13223, "urooow", "txt", 60);
//        Controller controller = new Controller();
//        controller.put(storage, file);
//        controller.put(storage, file1);
//        controller.put(storage, file2);
//        controller.put(storage, file4);
//        controller.put(storage, file5);
//        print(storage);
//
//        System.out.println();
//
////        controller.delete(storage, file4);
////        print(storage);
//
//        System.out.println();
//
//        controller.transferAll(storage, storage1);
//        print(storage1);
//
//        System.out.println();
//        Storage storage2 = new Storage(14, new File[5], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 500);
//        controller.transferFile(storage, storage2, 1225);
//        print(storage2);


        //проверка метода put()
        Storage storagePut = new Storage(154, new File[10], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 100);
        File filePut = new File(1223, "fdf42", "pdf", 45);
        File file1Put = new File(1225, "phd22", "pdf", 46);
        File file2Put = new File(1226, "ase34", "txt", 60);
        Controller controller1 = new Controller();
        controller1.put(storagePut, filePut);
        controller1.put(storagePut, file1Put);
        controller1.put(storagePut, file2Put);
        print(storagePut);
        //метод Put() с ошибкой на формат
//        File file3Put = new File(1235, "phd22", "rar", 46);
//        controller1.put(storagePut, file3Put);
//        print(storagePut);
        //метод put() с ошибкой на максимальный размер
//        Storage storage1Put = new Storage(154, new File[10], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 10);
//        File file4Put = new File(1135, "phd22", "pdf", 46);
//        File file5Put = new File(1135, "phd22", "pdf", 46);
//        File file6Put = new File(1135, "phd22", "pdf", 46);
//        File file7Put = new File(1135, "phd22", "pdf", 46);
//        File file8Put = new File(1135, "phd22", "pdf", 46);
//        File file9Put = new File(1335, "phd22", "pdf", 46);
//        File file10Put = new File(1435, "phd22", "pdf", 46);
//        File file11Put = new File(1535, "phd22", "pdf", 46);
//        File file12Put = new File(1635, "phd22", "pdf", 46);
//        File file13Put = new File(1735, "phd22", "pdf", 46);
//        File file14Put = new File(1835, "phd22", "pdf", 46);
//        controller1.put(storage1Put, file4Put);
//        controller1.put(storage1Put, file5Put);
//        controller1.put(storage1Put, file6Put);
//        controller1.put(storage1Put, file7Put);
//        controller1.put(storage1Put, file8Put);
//        controller1.put(storage1Put, file9Put);
//        controller1.put(storage1Put, file10Put);
//        controller1.put(storage1Put, file11Put);
//        controller1.put(storage1Put, file12Put);
//        controller1.put(storage1Put, file13Put);
//        controller1.put(storage1Put, file14Put);
//        print(storagePut);
        //метод Put() с ошибкой на айди
//        File file3Put = new File(1223, "phd22", "pdf", 46);
//        controller1.put(storagePut, file3Put);
//        print(storagePut);
        //метод put() с ошибкой длины имени
//        File file4Put = new File(1229, "hfkaqwyeuilxchjsa", "pdf", 46);
//        controller1.put(storagePut, file4Put);
//        print(storagePut);
        //метод put() с null переменной
        File file3Put = new File(1523, "fdf42", "pdf", 45);
        controller1.put(storagePut, file3Put);
        print(storagePut);


        System.out.println();
        //проверка метода delete()
        controller1.delete(storagePut, file3Put);
        print(storagePut);
        //проверка метода delete() с пустым файлом
//        controller1.delete(storagePut, null);
//        print(storagePut);


        System.out.println("transferAll");
        //проверка метода transferAll()
        Storage storageTrAll = new Storage(154, new File[10], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 100);
        controller1.transferAll(storagePut, storageTrAll);
        print(storageTrAll);
        System.out.println();
        Storage storageTrAll1 = new Storage(154, new File[10], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 100);
        File file4Put = new File(1135, "phd22", "pdf", 46);
        File file5Put = new File(1136, "phd22", "pdf", 46);
        File file6Put = new File(1199, "phd22", "pdf", 46);
        controller1.put(storageTrAll1, file4Put);
        controller1.put(storageTrAll1, file5Put);
        controller1.put(storageTrAll1, file6Put);
        //controller1.transferAll(storageTrAll1, storageTrAll);
        print(storageTrAll);
        //проверка метода transferAll() с другими данными во втором сторедже
//        System.out.println();
//        Storage storageTrAll1 = new Storage(154, new File[2], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 100);
//        controller1.transferAll(storagePut, storageTrAll1);
//        print(storageTrAll1);
        //проверка метода transferFile()
        System.out.println("transferFile()");
        controller1.transferFile(storageTrAll1, storageTrAll, 1199);
        print(storageTrAll);


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
