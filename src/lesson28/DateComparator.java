package lesson28;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Valik on 01.10.2018.
 */
public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
//        if(o1.getDateCreated().equals(null))
//            return 1;

        System.out.println("DateComparator is used");

        /*try {
            if (o1.getDateCreated().equals(null));
        }catch (NullPointerException e) {
            return 1;
        }
        try {
            if (o2.getDateCreated().equals(null));
        }catch (NullPointerException e) {
            return -1;
        }*/

        Validator<Date, Date> dateValidator = new Validator<>();

        if (dateValidator.validator(o1.getDateCreated(), o2.getDateCreated()) == 0)
            return o2.getDateCreated().compareTo(o1.getDateCreated());
        return dateValidator.validator(o1.getDateCreated(), o2.getDateCreated());
    }
}
