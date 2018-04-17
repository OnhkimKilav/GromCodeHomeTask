package lesson11.biginterfaceexample;

/**
 * Created by Valik on 17.03.2018.
 */
public class Storage {
    private File[] files = new File[5];

    public Storage(File[] files) {
        this.files = files;
    }

    public File[] getFiles() {
        return files;
    }
}
