package lesson19.homeTask;

import java.awt.*;
import java.util.NoSuchElementException;

/**
 * Created by Valik on 04.06.2018.
 */
public class Controller {
    public File put(Storage storage, File file) throws Exception {
        validate(storage, file);

        int index = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 == null) {
                storage.getFiles()[index] = file;
                break;
            }
            index++;
        }
        return storage.getFiles()[index];
    }

    public void delete(Storage storage, File file) throws Exception {

        File fileDel = null;
        int index = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 != null) {
                if (file1.equals(file)) {
                    fileDel = file;
                }
            }
            index++;
        }
        if (fileDel == null)
            throw new Exception("File " + file.toString() + " not found");

        index = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 != null) {
                if (fileDel.equals(file1)) {
                    storage.getFiles()[index] = null;
                    break;
                }
            }
            index++;
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        int index = quantityFilesInStorage(storageTo);

        for (File file1 : storageFrom.getFiles()) {
            if (file1 == null)
                break;
            for (File file : storageTo.getFiles()) {
                validate(storageTo, file1);
                storageTo.getFiles()[index] = file1;
                break;
            }
            index++;
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        int index = quantityFilesInStorage(storageTo);

        for (File file1 : storageFrom.getFiles()) {
            if (file1 == null)
                break;
            for (File file : storageTo.getFiles()) {
                validate(storageTo, file1);
                if (file1.getId() == id) {
                    storageTo.getFiles()[index] = file1;
                    break;
                }
            }
        }
    }

    private static void validate(Storage storage, File file) throws Exception {
        checkId(storage, file);
        checkFormat(storage, file);
        checkForFreePlace(storage);
        checkSize(storage, file.getSize());
    }

    private static int quantityFilesInStorage(Storage storageTo) {
        int index = 0;
        for (File file : storageTo.getFiles()) {
            if (file != null)
                index++;
        }

        return index;
    }

    private static void checkForFreePlace(Storage storage) throws Exception {
        for (File file : storage.getFiles()) {
            if (file == null)
                return;
        }
        throw new Exception("No free place in storage " + storage.getId());
    }


    //проверка на формат

    private static boolean checkFormat(Storage storage, File file) throws Exception {
        for (String string : storage.getFormatsSupported()) {
            if (file.getFormat().equals(string))
                return true;
        }

        throw new Exception(file.getFormat() + "is not supported in storage " + storage.getId());
    }


    //проверка на максимальный размер хранилища

    private static void checkSize(Storage storage, long filesize) throws Exception {

        long usedSize = 0;
        for (File file : storage.getFiles()) {
            if (file != null)
                usedSize += file.getSize();
        }

        if (usedSize + filesize > storage.getStorageSize())
            throw new Exception("No free space in storage " + storage.getId());
    }

    //проверка на одинаковые айди

    private static boolean checkId(Storage storage, File file) throws Exception {

        for (File file1 : storage.getFiles()) {
            if (file1 != null && file1.getId() == file.getId())
                throw new Exception("File " + file.getId() + " already exist is storage " + storage.getId());
        }

        return true;
    }
}