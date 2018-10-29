package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by Valik on 25.10.2018.
 */

public class ReadWriteFile {

    public static void main(String[] args) {
        readFile("D:/Programs/YandexDisk/Программач Java/какие то файлы/test.txt");
        writeFile("D:/Programs/YandexDisk/Программач Java/какие то файлы/test1.txt");
    }

    private static void readFile(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
    }


    private static void writeFile(String path) {

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));){
            //TODO use other constructor
            bufferedWriter.append("\n");
            bufferedWriter.append("TTTT");
        }catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

}
