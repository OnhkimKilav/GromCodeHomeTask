package lesson19.homeTask;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Valik on 05.06.2018.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //проверка метода put()
        Storage storagePut = new Storage(154, new File[10], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 500);
        File filePut = new File(1223, "fdf42", "pdf", 1);
        File file1Put = new File(1225, "phd22", "pdf", 1);
        File file2Put = new File(1226, "ase34", "txt", 1);
        File file3Put = new File(1227, "ase34", "txt", 1);
        File file4Put = new File(1228, "ase34", "txt", 1);
        File file5Put = new File(1229, "ase34", "txt", 1);
        File file6Put = new File(1220, "ase34", "txt", 1);
        File file7Put = new File(1221, "ase34", "txt", 1);
        File file8Put = new File(1222, "ase34", "txt", 1);
        File file9Put = new File(1233, "ase34", "txt", 1);
        //File file10Put = new File(1243, "ase34", "txt", 60);
        Controller controller1 = new Controller();
        controller1.put(storagePut, filePut);
        controller1.put(storagePut, file1Put);
        controller1.put(storagePut, file2Put);
        controller1.put(storagePut, file3Put);
        controller1.put(storagePut, file4Put);
        controller1.put(storagePut, file5Put);
        //controller1.put(storagePut, file6Put);
        //controller1.put(storagePut, file7Put);
        //controller1.put(storagePut, file8Put);
        //controller1.put(storagePut, file9Put);
        //controller1.put(storagePut, file10Put);
        print(storagePut);
        //метод Put() с ошибкой на формат
//        File file10Put = new File(1235, "phd22", "rar", 46);
//        controller1.put(storagePut, file3Put);
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
//        File file3Put = new File(1523, "fdf42", "pdf", 45);
//        controller1.put(storagePut, file3Put);
//        print(storagePut);
//
//
//        System.out.println();
//        //проверка метода delete()
//        controller1.delete(storagePut, file3Put);
//        print(storagePut);
//        //проверка метода delete() с пустым файлом
////        controller1.delete(storagePut, null);
////        print(storagePut);
//
//
//        System.out.println("transferAll");
//        //проверка метода transferAll()
//        Storage storageTrAll1 = new Storage(154, new File[10], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 200);
//        File file11Put = new File(1135, "phd22", "pdf", 46);
//        File file12Put = new File(1136, "phd22", "pdf", 46);
//        File file13Put = new File(1199, "phd22", "pdf", 46);
//        File file14Put = new File(1555, "phd22", "pdf", 46);
//        controller1.put(storageTrAll1, file11Put);
//        controller1.put(storageTrAll1, file12Put);
//        controller1.put(storageTrAll1, file13Put);
//        controller1.put(storageTrAll1, file14Put);
//        controller1.transferAll(storageTrAll1, storagePut);
//        print(storagePut);

        //проверка метода transferFile
        System.out.println("transferFile");
        Storage storageFile = new Storage(154, new File[10], new String[]{"txt", "pdf", "png", "jpg"}, "Ukrain", 200);
        File file11Put = new File(1135, "phd22", "pdf", 46);
        File file12Put = new File(1136, "phd22", "pdf", 46);
        File file13Put = new File(1199, "phd22", "pdf", 46);
        File file14Put = new File(1555, "phd22", "pdf", 46);
        controller1.put(storageFile, file11Put);
        controller1.put(storageFile, file12Put);
        controller1.put(storageFile, file13Put);
        controller1.put(storageFile, file14Put);
        controller1.transferFile(storageFile, storagePut, 1136);
        print(storagePut);


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