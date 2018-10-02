package lesson28;

import java.util.Comparator;

/**
 * Created by Valik on 01.10.2018.
 */
public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2){
//        if(o1.getDateCreated().equals(null))
//            return 1;

        System.out.println("DateComparator is used");
        System.out.println(o1.getDateCreated().getTime());
        System.out.println(o2.getDateCreated().getTime());

        return (int) (o1.getDateCreated().getTime() - o2.getDateCreated().getTime());
    }
}
