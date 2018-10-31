package lesson34.hometask.task1.task4;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Valik on 30.10.2018.
 */
public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        try {
            Files.copy(fileFrom.toPath(),fileTo.toPath());
        } catch (IOException e) {
            System.out.println("Copy by dint of Files failed");
        }

    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        try {
            FileUtils.copyFile(fileFrom, fileTo);
        } catch (IOException e) {
            System.out.println("Copy by dint of ApacheIO failed");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists())
            throw new FileNotFoundException("File " + fileFromPath + " does not exist");
        if (fileTo.exists())
            throw new FileNotFoundException("File " + fileToPath + " exists");
        if (!fileFrom.canRead())
            throw new Exception("File " + fileFromPath + " does not have permissions to be read");
        if (fileTo.canWrite())
            throw new Exception("File " + fileToPath + " has permissions to be written");
    }
}
