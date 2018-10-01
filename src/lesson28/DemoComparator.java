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

        System.out.println(capabilities);

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities);
/*
        capabilities.sort(new DateComparator());

        System.out.println(capabilities);*/

        capabilities.sort(new FullComparator());

        System.out.println(capabilities);


        /*Comparator<Capability> comparator = new Comparator<Capability>() {
            @Override
            public int compare(Capability o1, Capability o2) {

                //если channelName не равно - сравниваю по нему
                //если равно - перехожу к fingerprint
                //если fingerprint не равно - сравниваю по нему
                //если равно - перехожу к dateCreated
                //если dateCreated не равно - сравниваю по нему
                //если равно - объекты равны

                if(!o1.getChannelName().equals(o2))
                    return o1.getChannelName().compareTo(o2.getChannelName());


                return 0;
            }
        };*/
    }
}
