package lesson19.homeTask;

/**
 * Created by Valik on 04.06.2018.
 */
public class Controller {
    public void put(Storage storage, File file) {

        testExceptionOnNullStorageAndFile(storage, file);

        int index = 0;

        for (File file1 : storage.getFiles()) {
            if (file1 == null && testExceptionStorageOnFormats(storage, file) && testExceptionStorageOnTheSize(storage) && testExceptionFileOnIdWithStorage(storage, file)) {
                storage.getFiles()[index] = file;
                break;
            }
            index++;
        }
    }

    public void delete(Storage storage, File file) {
        testExceptionOnNullStorageAndFile(storage, file);

        int index = 0;
        for (File file1 : storage.getFiles()) {
            if (file1.equals(file)) {
                storage.getFiles()[index] = null;
                break;
            }
            index++;
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        testExceptionOnNullStorageAndStorage(storageFrom, storageTo);

        int index = quantityFilesInStorage(storageTo);

        for (File file1 : storageFrom.getFiles()) {
            if (file1 == null)
                break;
            for (File file : storageTo.getFiles()) {
                if (testExceptionStorageOnFormats(storageTo, file1) && testExceptionFileOnIdWithStorage(storageTo, file1) && testExceptionStorageOnTheSize(storageTo)) {
                    storageTo.getFiles()[index] = file1;
                    break;
                }
            }
            index++;
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        testExceptionOnNullStorageAndStorage(storageFrom, storageTo);

        int index = quantityFilesInStorage(storageTo);

        for (File file1 : storageFrom.getFiles()) {
            if (file1 == null)
                break;
            for (File file : storageTo.getFiles()) {
                if (file1.getId() == id && testExceptionStorageOnFormats(storageTo, file1) && testExceptionFileOnIdWithStorage(storageTo, file1) && testExceptionStorageOnTheSize(storageTo)) {
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

    private void testExceptionOnNullStorageAndFile(Storage storage, File file) {
        if (storage == null || file == null)
            throw new NullPointerException("Storage or file is null");
    }

    private void testExceptionOnNullStorageAndStorage(Storage storage, Storage storage1) {
        if (storage == null || storage1 == null)
            throw new NullPointerException("Storage or file is null");
    }

    //проверка на формат

    private boolean testExceptionStorageOnFormats(Storage storage, File file) {
        if (!testStorageOnTheFormats(storage, file))
            throw new RuntimeException("File " + file.getId() + " don't have a format " + file.getFormat() + " in a Storage.");
        return true;
    }

    private boolean testStorageOnTheFormats(Storage storage, File file) {
        //нужно сравнить формат файла с форматом всех возможных форматов storage
        boolean step = false;
        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat() == null)
                throw new NullPointerException("Format in the file " + file.getId() + " equal null");
            if (file.getFormat().equals(storage.getFormatsSupported()[i])) {
                step = true;
            }
        }
        return step;
    }

    //проверка на максимальный размер хранилища

    private boolean testExceptionStorageOnTheSize(Storage storage) {
        if (!testStorageOnTheSize(storage))
            throw new RuntimeException("Size a storage more than indicate - " + storage.getStorageSize());
        return true;
    }

    private boolean testStorageOnTheSize(Storage storage) {
        if (storage.getStorageSize() <= findQuantityFilesInStorage(storage))
            return false;
        return true;
    }

    private int findQuantityFilesInStorage(Storage storage) {
        int index = 0;
        for (File file : storage.getFiles())
            index++;
        return index;
    }

    //проверка на одинаковые айди

    private boolean testExceptionFileOnIdWithStorage(Storage storage, File file) {
        if (!testFileOnIdWithStorage(storage, file)) {
            throw new RuntimeException("File " + file.getId() + " already exists in the storage");
        }
        return true;
    }

    private boolean testFileOnIdWithStorage(Storage storage, File file) {
        for (File file1 : storage.getFiles()) {
            if (file1 == null)
                return true;
            if (file1.getId() == file.getId())
                return false;
        }
        return true;
    }


}
