package lesson35.DAO;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Valik on 20.11.2018.
 */
public abstract class GeneralDAO {

    public abstract Object transformationStringToUser(String[] values) throws Exception;

    public static StringBuffer readFile(File path){
        StringBuffer res = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path.toPath() + " failed");
        }

        return res;
    }


    public static void cleaningFile(File path){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.append("");
        } catch (IOException e) {
            System.err.println("File " + path.toPath() + " can't cleaning");
        }
    }

    public static String dateToStr(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
    }

    public static Date strToDate(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");
        Date docDate= format.parse(s);
        return docDate;
    }
}
