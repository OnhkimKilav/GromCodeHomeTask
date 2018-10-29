package lesson34.hometask.task1;

import java.io.*;

/**
 * Created by Valik on 28.10.2018.
 */
public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        //Проверить что файл есть +
        //проверить права +
        //считать контент файла from +
        //записать контент в файл to +
        validate(fileFromPath, fileToPath);

        writeContent(fileToPath, readContent(fileFromPath));
    }

    private static StringBuffer readContent(String fileFromPath) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileFromPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }
            res.replace(res.length() - 1, res.length(), "");

        } catch (FileNotFoundException e) {
            System.err.println("File " + fileFromPath + " doesn't exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + fileFromPath + " failed");
        }

        return res;
    }

    private static void writeContent(String path, StringBuffer contentToWrite) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            bufferedWriter.append(contentToWrite);
        }catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileTo.exists())
            throw new FileNotFoundException("File " + fileToPath + " does not exist");
        if (!fileFrom.canRead())
            throw new Exception("File " + fileFromPath + " does not have permissions to be read");
        if (!fileTo.canWrite())
            throw new Exception("File " + fileToPath + " does not have permissions to be written");
    }
}
