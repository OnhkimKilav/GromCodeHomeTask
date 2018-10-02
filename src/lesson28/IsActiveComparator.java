package lesson28;

import java.util.Comparator;

/**
 * Created by Valik on 01.10.2018.
 */
public class IsActiveComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
        System.out.println("IsActiveComparator is user");

        if(o1.isActive() && !o2.isActive())
            return -1;
        else if((o1.isActive() && o2.isActive()) || (!o1.isActive() && !o2.isActive()))
            return 0;
        else
            return 1;
    }
}
