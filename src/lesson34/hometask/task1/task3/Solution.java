package lesson34.hometask.task1.task3;

import java.io.*;

/**
 * Created by Valik on 29.10.2018.
 */
public class Solution {
    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);
        String fileContent = readContent(fileFromPath).toString();

        String[] sentences = fileContent.split(".");

        StringBuffer sentencesWithWord = new StringBuffer();
        for(String sentence : sentences){
            if(sentence.contains(word) && sentence.length() > 10){
                sentencesWithWord.append(sentence).append(".");
                fileContent = fileContent.replace(sentencesWithWord + ".", "");
            }
        }

        StringBuffer fileToBackup = readContent(fileToPath);
        try{
            writeContent(fileFromPath, fileContent, false);
            writeContent(fileToPath, sentencesWithWord, true);
        }catch (IOException e){
            writeContent(fileFromPath, fileContent, false);
            writeContent(fileToPath, fileToBackup, false);
        }
    }

    private static StringBuffer readContent(String fileFromPath) throws IOException {
        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileFromPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        }catch (IOException e){
            throw new IOException("Reading from file " + fileFromPath + " failed", e);
        }

        return res;
    }

    private static <T extends CharSequence> void writeContent(String path, T contentToWrite, boolean append) throws IOException {
        try (BufferedWriter writerFileTo = new BufferedWriter(new FileWriter(path, append))) {
            writerFileTo.append(contentToWrite);
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
