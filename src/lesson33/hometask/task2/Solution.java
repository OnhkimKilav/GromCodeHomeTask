package lesson33.hometask.task2;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Valik on 26.10.2018.
 */
public class Solution {
    public static void readFileByConsolePath(String path){
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(path));
        }catch (FileNotFoundException e){
            System.err.println("File with path " + path + " not found");
            return;
        }

        try {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Can't read file by path " + path);
        }
        finally {
            IOUtils.closeQuietly(br);
        }
    }
}
