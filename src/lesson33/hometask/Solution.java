package lesson33.hometask;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Valik on 25.10.2018.
 */
public class Solution {
    public static void writeToFileFromConsole(String path) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = null;
        String message = null;
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter file content to write in the file");
        try {
            writer = new BufferedWriter(new FileWriter(path, true));
            while (!(message = reader.readLine()).equals("wr")) {
                try {
                    writer.write(message);
                    writer.append('\n');
                } catch (IOException e) {
                    System.out.println("Can't write to file with path " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("File with path " + path + " not found");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(writer);
        }
    }
}
