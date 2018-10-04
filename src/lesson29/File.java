package lesson29;

/**
 * Created by Valik on 03.10.2018.
 */
public class File {
    private String fileName;
    private long sizeInBytes;

    public File(String fileName, long sizeInBytes) {
        this.fileName = fileName;
        this.sizeInBytes = sizeInBytes;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (sizeInBytes != file.sizeInBytes) return false;
        return fileName.equals(file.fileName);
    }

    @Override
    public int hashCode() {
        int result = fileName.hashCode();
        result = 31 * result + (int) (sizeInBytes ^ (sizeInBytes >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", sizeInBytes=" + sizeInBytes +
                '}';
    }
}
