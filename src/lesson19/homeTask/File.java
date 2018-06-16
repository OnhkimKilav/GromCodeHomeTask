package lesson19.homeTask;

/**
 * Created by Valik on 31.05.2018.
 */
public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception {
        if (!validateGetName(name)) {
            throw new Exception("File name can't be more 10 chars");
        }

        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    private boolean validateGetName(String name) {
        if (name == null)
            throw new NullPointerException("File name is equal null");
        if (name.isEmpty() || name.length() > 10) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
