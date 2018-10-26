package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by Valik on 25.10.2018.
 */

public class ReadWriteFile {
    private void readFile(String path){
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(path));
        }catch (FileNotFoundException e){
            System.err.println("File doesn't exist");
            return;
        }

        try {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Reading from file " + path + " failed");
        }
        finally {
            IOUtils.closeQuietly(br);
        }
    }

    private void writeFile(String path) {
        BufferedWriter bufferedWriter = null;
        try {
            //TODO use other constructor
            bufferedWriter = new BufferedWriter(new FileWriter(path, true));
            bufferedWriter.append("\n");
            bufferedWriter.append("TTTT");
            
        }catch (IOException e) {
            System.err.println("Can't write to file");
    }
        finally {
            IOUtils.closeQuietly(bufferedWriter);
        }
    }

}
