package lesson28;

import java.util.*;

/**
 * Created by Valik on 01.10.2018.
 */
public class DemoComparator {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.set(2012, Calendar.JANUARY, 1);
        cal2.set(2013, Calendar.JANUARY, 1);
        Date date = cal.getTime();
        Date date1 = cal2.getTime();

        Capability capability1 = new Capability(1001, "test", "rrrr", true, date);
        Capability capability2 = new Capability(1005, "test", "rrrr", false, new Date());
        Capability capability3 = new Capability(900, "test", "rrrr", true, date1);

        ArrayList<Capability> capabilities = new ArrayList<>();

        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);


        capabilities.sort(new DateComparator());
        //capabilities.sort(new IsActiveComparator());

        //capabilities.sort(new FullComparator());
        System.out.println(capabilities);

    }
}
