package lesson19.homeTask;

import java.util.NoSuchElementException;

/**
 * Created by Valik on 04.06.2018.
 */
public class Controller {
    public File put(Storage storage, File file) throws Exception {
        if (testExceptionFormats(storage, file) && testExceptionSize(storage) && testExceptionId(storage, file)) {
        }

        int index = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 == null) {
                storage.getFiles()[index] = file;
                break;
            }
            index++;
        }
        return file;
    }

    public void delete(Storage storage, File file) {

        int index = 0;
        for (File file1 : storage.getFiles()) {
            if (file1.equals(file)) {
                storage.getFiles()[index] = null;
                break;
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
                if (testExceptionFormats(storageTo, file1) && testExceptionId(storageTo, file1) && testExceptionSize(storageTo)) {
                    storageTo.getFiles()[index] = file1;
                    break;
                }
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
                if (file1.getId() == id && testExceptionFormats(storageTo, file1) && testExceptionId(storageTo, file1) && testExceptionSize(storageTo)) {
                    storageTo.getFiles()[index] = file1;
                    break;
                }
            }
        }
    }

    private int quantityFilesInStorage(Storage storageTo) {
        int index = 0;
        for (File file : storageTo.getFiles()) {
            if (file != null)
                index++;
        }

        return index;
    }

    //проверка на формат

    private boolean testExceptionFormats(Storage storage, File file) throws Exception {

        for (String string : storage.getFormatsSupported()) {
            if (file.getFormat() == null)
                throw new NullPointerException("Format in the file " + file.getId() + " equal null");
            if (file.getFormat().equals(string)) {
                return true;
            }
        }

        throw new Exception("File " + file.getId() + " don't have a format " + file.getFormat() + " in a Storage.");
    }


    //проверка на максимальный размер хранилища

    private boolean testExceptionSize(Storage storage) throws Exception {
        int index = 0;

        for (File file : storage.getFiles())
            index++;

        if (storage.getStorageSize() <= index)
            throw new Exception("Size a storage more than indicate - " + storage.getStorageSize());

        return true;
    }

    //проверка на одинаковые айди

    private boolean testExceptionId(Storage storage, File file) throws Exception {

        for (File file1 : storage.getFiles()) {
            if (file1 == null)
                return true;

            if (file1.getId() == file.getId())
                throw new Exception("File " + file.getId() + " already exists in the storage");
        }

        return true;
    }
}
