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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file1 = (File) o;

        if (id != file1.id) return false;
        if (size != file1.size) return false;
        if (name != null ? !name.equals(file1.name) : file1.name != null) return false;
        return format != null ? format.equals(file1.format) : file1.format == null;
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
