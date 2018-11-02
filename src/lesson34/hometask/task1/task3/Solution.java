package lesson34.hometask.task1.task3;

import java.io.*;

/**
 * Created by Valik on 29.10.2018.
 */
public class Solution {
    private static StringBuffer trueString = new StringBuffer();
    private static StringBuffer falseString = new StringBuffer();

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        findingStringByWord(readContent(fileFromPath), word);

        writeContent(fileToPath, fileFromPath);
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

    private static void findingStringByWord(StringBuffer stringBuffer, String word) {

        String s = String.valueOf(stringBuffer);
        String[] strings = s.split("\\.");
        for(String s1 : strings){
            if (s1.contains(word) && s1.length() >= 10) {
                trueString.append(s1 + ".");
            }
            else falseString.append(s1 + ".");
        }
    }

    private static void writeContent(String fileToPath, String fileFromPath) {
        try (BufferedWriter writerFileTo = new BufferedWriter(new FileWriter(fileToPath, true)); BufferedWriter writerFileFrom = new BufferedWriter(new FileWriter(fileFromPath))) {
            writerFileTo.append(trueString);
            writerFileFrom.append(falseString);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists())
            throw new FileNotFoundException("File " + fileFromPath + " does not exist");
        if (!fileTo.exists())
            throw new FileNotFoundException("File " + fileToPath + " does not exist");
        if (!fileFrom.canRead())
            throw new Exception("File " + fileFromPath + " does not have permissions to be read");
        if (!fileTo.canWrite())
            throw new Exception("File " + fileToPath + " does not have permissions to be written");
    }
}
