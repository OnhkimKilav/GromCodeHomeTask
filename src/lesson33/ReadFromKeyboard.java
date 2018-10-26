package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Valik on 19.10.2018.
 */
public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException {
        readKeyboardWithIOStream1();
    }

    private static void readKeyboardWithScanner(){
        //using scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name");

        System.out.println("Hello, " + scanner.nextLine());

        scanner.close();
    }


    private static void readKeyboardWithIOStream1(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter your name");

        try {
            System.out.println("Hello, " + reader.readLine() + "!");
        }catch (IOException e){
            System.out.println("Reading from keyboard failed");
        }finally {
            try {
                reader.close();
            }catch (IOException e){
                System.out.println("Closing streams failed");
            }
        }

    }

    private static void readKeyboardWithIOStream2(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter your name");

        try {
            System.out.println("Hello, " + reader.readLine() + "!");
        }catch (IOException e){
            System.out.println("Reading from keyboard failed");
        }finally {
            IOUtils.closeQuietly(reader);
        }

    }
}
