package lesson33.hometask;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by Valik on 25.10.2018.
 */
public class Solution {
    public static void writeToFileFromConsole(String path) throws FileNotFoundException {
        if (!new File(path).canRead())
            throw new FileNotFoundException("File with path " + path + " not found");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = null;
        String message;

        System.out.println("Enter file content to write in the file");
        try {
            writer = new BufferedWriter(new FileWriter(path, true));
            while (!(message = reader.readLine()).equals("wr")) {
                writer.write(message);
                writer.append("\r\n");
            }
        } catch (IOException e) {
            System.out.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(writer);
        }
    }
}
