package lesson28;

import java.util.Comparator;

/**
 * Created by Valik on 01.10.2018.
 */
public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) throws NullPointerException{

        return (int) (o1.getDateCreated().getTime() - o2.getDateCreated().getTime());
    }
}
